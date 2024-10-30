package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import Tools.Entity;
import Tools.RISCVsema.arithmetic_i;
import Tools.RISCVsema.arithmetic_r;
import Tools.RISCVsema.command;
import Tools.RISCVsema.Pseudoinstruction.li;
import Tools.RISCVsema.Pseudoinstruction.mv;
import Tools.RISCVsema.operand.immnum;
import Tools.RISCVsema.operand.phyreg;
import Tools.RISCVsema.operand.virtreg;
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
  public ArrayList<command> toasm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    if (funcname.equals("newarray")) {
      ((constant32)args.get(1)).value = 4;
    }
    phyreg sp = regAlloc.GetPhyReg("sp");
    register ra = regAlloc.raSaveRegister;
    ret.addAll(regAlloc.StorePhyReg(regAlloc.GetPhyReg("ra"), regAlloc.GetVirtReg(ra)));
    HashMap<Integer, register> callerSavedMap = new HashMap<>();
    HashSet<Integer> hashStored = new HashSet<>();
    int cnt;
    for (register a : liveVarOut) {
      if (callerSavedMap.containsKey(a.regId)) {
        continue;
      }
      if (regAlloc.callerSaveRegMap.containsKey(a.regId)) {
        ret.addAll(regAlloc.StorePhyReg(regAlloc.GetPhyReg(a.regId), regAlloc.GetVirtReg(regAlloc.callerSaveRegMap.get(a.regId))));
        callerSavedMap.put(a.regId, regAlloc.callerSaveRegMap.get(a.regId));
      }
    }
    cnt = ret.size();
    boolean flag = false;
    if (args.size() <= 8) {
      for (int i = 0; i < args.size(); i++) {
        Entity whereToLoad = args.get(i);
        if (args.get(i) instanceof register) {
          virtreg reg = regAlloc.GetVirtReg((register)args.get(i));
          if (reg.regId != -1 && 10 <= reg.regId && reg.regId < i + 10) {
            ret.addAll(cnt, regAlloc.StorePhyReg(regAlloc.GetPhyReg(reg.regId), regAlloc.GetVirtReg(regAlloc.callerSaveRegMap.get(reg.regId))));
            whereToLoad = regAlloc.callerSaveRegList.get(reg.regId - 10).virtualReg;
          }
        }
        ret.addAll(regAlloc.LoadToPhyReg(regAlloc.GetPhyReg("a" + i), whereToLoad));
      }
    } else {
      flag = true;
      for (int i = 0; i < 8; i++) {
        Entity whereToLoad = args.get(i);
        if (args.get(i) instanceof register) {
          virtreg reg = regAlloc.GetVirtReg((register)args.get(i));
          if (reg.regId != -1 && 10 <= reg.regId && reg.regId < i + 10 && !hashStored.contains(reg.regId)) {
            ret.addAll(cnt, regAlloc.StorePhyReg(regAlloc.GetPhyReg(reg.regId), regAlloc.GetVirtReg(regAlloc.callerSaveRegMap.get(reg.regId))));
            whereToLoad = regAlloc.callerSaveRegList.get(reg.regId - 10).virtualReg;
            hashStored.add(reg.regId);
          }
        }
        ret.addAll(regAlloc.LoadToPhyReg(regAlloc.GetPhyReg("a" + i), whereToLoad));
      }
      phyreg t1 = regAlloc.GetPhyReg("t1"), s0 = regAlloc.GetPhyReg("s0");
      int stacksize = (int)Math.ceil((8 - args.size()) * 4 / 16) * 16;
      if (stacksize > 2047 || stacksize < -2048) {
        ret.add(new li(t1, new immnum(stacksize)));
        ret.add(new arithmetic_r(s0, sp, t1, arithmetic_r.Opcode.add));
      } else {
        ret.add(new arithmetic_i(s0, sp, new immnum(stacksize), arithmetic_i.Opcode.addi));
      }
      for (int i = 8; i < args.size(); i++) {
        phyreg argsp = regAlloc.GetPhyReg(args.get(i), 1);
        ret.addAll(regAlloc.LoadToPhyReg(argsp, args.get(i)));
        ret.addAll(regAlloc.StorePhyReg(argsp, regAlloc.GetVirtReg(s0, (i - 8) * 4, null)));
      }
      ret.add(new mv(sp, s0));
    }
    ret.add(new Tools.RISCVsema.Pseudoinstruction.call(funcname));
    phyreg t1 = regAlloc.GetPhyReg("t1");
    int stacksize = -(int)Math.ceil((8 - args.size()) * 4 / 16) * 16;
    if (flag) {
      if (stacksize > 2047 || stacksize < -2048) {
        ret.add(new li(t1, new immnum(stacksize)));
        ret.add(new arithmetic_r(sp, sp, t1, arithmetic_r.Opcode.add));
      } else {
        ret.add(new arithmetic_i(sp, sp, new immnum(stacksize), arithmetic_i.Opcode.addi));
      }
    }
    for (Integer keySet : callerSavedMap.keySet()) {
      ret.addAll(regAlloc.LoadToPhyReg(regAlloc.GetPhyReg(keySet), regAlloc.GetVirtReg(callerSavedMap.get(keySet))));
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
  
  @Override
  public void initialize() {
    if (res != null) {
      if (!res.isGlobal) {
        defVar.add(res);
      }
    }
    for (Entity arg : args) {
      if (arg instanceof register) {
        if (!((register)arg).isGlobal) {
          liveVarIn.add((register)arg);
        }
      }
    }
  }
}
