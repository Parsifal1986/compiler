package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import Tools.Entity;
import Tools.RISCVsema.arithmetic_i;
import Tools.RISCVsema.arithmetic_r;
import Tools.RISCVsema.command;
import Tools.RISCVsema.Pseudoinstruction.li;
import Tools.RISCVsema.Pseudoinstruction.mv;
import Tools.RISCVsema.operand.immnum;
import Tools.RISCVsema.operand.phyreg;
import codegen.RegAlloca;

public class call extends statement {
  public String funcname;
  public register res; 
  public String retType;
  public ArrayList<Entity> args;

  public call(String funcname, register res, String retType, ArrayList<Entity> args) {
    this.funcname = funcname;
    this.res = res;
    this.retType = retType;
    this.args = args;
  }

  @Override
  public void print(PrintStream out) {
    if (res != null && retType != "void") {
      out.print(res.tostring() + " = call " + retType + " @" + funcname + "(");
    } else {
      out.print("call " + retType + " " + "@" + funcname + "(");
    }
    for (int i = 0; i < args.size(); i++) {
      out.print(args.get(i).type + " " + args.get(i).tostring());
      if (i != args.size() - 1) {
        out.print(", ");
      }
    }
    out.println(")");
  }

  @Override
  public ArrayList<command> toAsm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    if (funcname.equals("newarray")) {
      ((constant32)args.get(1)).value = 4;
    }
    register ra = new register("i32");
    ret.addAll(regAlloc.StorePhyReg(regAlloc.GetPhyReg("ra"), regAlloc.GetVirtReg(ra)));
    boolean flag = false;
    if (args.size() <= 8) {
      for (int i = 0; i < args.size(); i++) {
        ret.addAll(regAlloc.LoadToPhyReg(regAlloc.GetPhyReg("a" + i), args.get(i)));
      }
    } else {
      flag = true;
      for (int i = 0; i < 8; i++) {
        ret.addAll(regAlloc.LoadToPhyReg(regAlloc.GetPhyReg("a" + i), args.get(i)));
      }
      phyreg t3 = regAlloc.GetPhyReg("t3"), sp = regAlloc.GetPhyReg("sp"), s0 = regAlloc.GetPhyReg("s0");
      int stacksize = (int)Math.ceil((8 - args.size()) * 4 / 16) * 16;
      if (stacksize > 2047 || stacksize < -2048) {
        ret.add(new li(t3, new immnum(stacksize)));
        ret.add(new arithmetic_r(s0, sp, t3, arithmetic_r.Opcode.add));
      } else {
        ret.add(new arithmetic_i(s0, sp, new immnum(stacksize), arithmetic_i.Opcode.addi));
      }
      for (int i = 8; i < args.size(); i++) {
        ret.addAll(regAlloc.LoadToPhyReg(regAlloc.GetPhyReg("t0"), args.get(i)));
        ret.addAll(regAlloc.StorePhyReg(regAlloc.GetPhyReg("t0"), regAlloc.GetVirtReg(s0, (i - 8) * 4, res)));
      }
      ret.add(new mv(sp, s0));
    }
    ret.add(new Tools.RISCVsema.Pseudoinstruction.call(funcname));
    phyreg t3 = regAlloc.GetPhyReg("t3"), sp = regAlloc.GetPhyReg("sp");
    int stacksize = -(int) Math.ceil((8 - args.size()) * 4 / 16) * 16;
    if (flag) {
      if (stacksize > 2047 || stacksize < -2048) {
        ret.add(new li(t3, new immnum(stacksize)));
        ret.add(new arithmetic_r(sp, sp, t3, arithmetic_r.Opcode.add));
      } else {
        ret.add(new arithmetic_i(sp, sp, new immnum(stacksize), arithmetic_i.Opcode.addi));
      }
    }
    if (res != null && retType != "void") {
      ret.addAll(regAlloc.StorePhyReg(regAlloc.GetPhyReg("a0"), regAlloc.GetVirtReg(res)));
    }
    ret.addAll(regAlloc.LoadToPhyReg(regAlloc.GetPhyReg("ra"), regAlloc.GetVirtReg(ra)));
    return ret;
  }

  @Override
  public void rename(HashMap<register, Entity> renameMap) {
    for (int i = 0; i < args.size(); i++) {
      if (args.get(i) instanceof register) {
        if (renameMap.containsKey((register)args.get(i))) {
          args.set(i, renameMap.get(args.get(i)));
        }
      }
    }
  }
  
}
