package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;

import Tools.Entity;
import Tools.RISCVsema.arithmetic_r;
import Tools.RISCVsema.command;
import Tools.RISCVsema.memory_i;
import Tools.RISCVsema.operand.immnum;
import Tools.RISCVsema.operand.phyreg;
import Tools.RISCVsema.operand.virtreg;
import codegen.RegAlloca;

public class getelementptr extends statement {
  public String type;
  public register reg;
  public register ptr;
  public ArrayList<Entity> index;

  public getelementptr(String type, register reg, register ptr, ArrayList<Entity> index) {
    this.type = type;
    this.reg = reg;
    this.ptr = ptr;
    this.index = index;
  }

  @Override
  public void print(PrintStream out) {
    out.print(reg.tostring() + " = getelementptr inbounds " + type + ", " + ptr.type + " " + ptr.tostring() + ", ");
    for (int i = 0; i < index.size(); i++) {
      out.print(index.get(i).type + " " + index.get(i).tostring());
      if (i != index.size() - 1) {
        out.print(", ");
      }
    }
    out.println();
  }

  @Override
  public ArrayList<command> toAsm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    phyreg t0 = regAlloc.GetPhyReg("t0");
    phyreg t1 = regAlloc.GetPhyReg("t1");
    phyreg t2 = regAlloc.GetPhyReg("t2");
    virtreg addr = regAlloc.GetVirtReg(ptr);
    ret.addAll(regAlloc.GetVirtregAddr(t0, addr));
    if (type.equals("i32") || type.equals("i8") || type.equals("ptr")) {
      for (int i = 0; i < index.size(); i++) {
        ret.add(new memory_i(t0, t0, new immnum(0), memory_i.Opcode.LW));
        Entity idx = index.get(i);
        ret.addAll(regAlloc.LoadToPhyReg(t1, idx));
        ret.addAll(regAlloc.LoadToPhyReg(t2, new constant32(4)));
        ret.add(new arithmetic_r(t1, t1, t2, arithmetic_r.Opcode.mul));
        ret.add(new arithmetic_r(t0, t0, t1, arithmetic_r.Opcode.add));
      }
    } else {
      for (int i = 1; i < index.size(); i++) {
        ret.add(new memory_i(t0, t0, new immnum(0), memory_i.Opcode.LW));
        Entity idx = index.get(i);
        ret.addAll(regAlloc.LoadToPhyReg(t1, idx));
        ret.addAll(regAlloc.LoadToPhyReg(t2, new constant32(4)));
        ret.add(new arithmetic_r(t1, t1, t2, arithmetic_r.Opcode.mul));
        ret.add(new arithmetic_r(t0, t0, t1, arithmetic_r.Opcode.add));
      }
    }
    ret.addAll(regAlloc.StorePhyReg(t0, regAlloc.GetVirtReg(reg)));
    return ret;
  }
}
