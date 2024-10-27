package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import Tools.Entity;
import Tools.RISCVsema.arithmetic_i;
import Tools.RISCVsema.arithmetic_r;
import Tools.RISCVsema.command;
import Tools.RISCVsema.operand.immnum;
import Tools.RISCVsema.operand.phyreg;
import codegen.RegAlloca;

public class cmp extends statement {
  public register dest;
  public Entity src1;
  public Entity src2;
  public opcode op;

  public cmp(register dest, Entity src1, Entity src2, opcode op) {
    this.dest = dest;
    this.src1 = src1;
    this.src2 = src2;
    this.op = op;
  }

  public enum opcode {
    eq, ne, slt, sgt, sle, sge
  }

  @Override
  public void print(PrintStream out) {
    out.println(dest.tostring() + " = icmp " + op + " " + src1.type + " " + src1.tostring() + ", " + src2.tostring());
  }

  @Override
  public ArrayList<command> toAsm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    phyreg r0 = regAlloc.GetPhyReg("t0"), r1 = regAlloc.GetPhyReg(src1, 0), r2 = regAlloc.GetPhyReg(src2, 1);
    ret.addAll(regAlloc.LoadToPhyReg(r1, src1));
    ret.addAll(regAlloc.LoadToPhyReg(r2, src2));
    switch (op) {
      case eq:
        ret.add(new arithmetic_r(r0, r1, r2, Tools.RISCVsema.arithmetic_r.Opcode.xor));
        ret.add(new arithmetic_i(r0, r0, new immnum(1), Tools.RISCVsema.arithmetic_i.Opcode.sltiu));
        break;
      case ne:
        ret.add(new arithmetic_r(r0, r1, r2, Tools.RISCVsema.arithmetic_r.Opcode.xor));
        break;
      case slt:
        ret.add(new arithmetic_r(r0, r1, r2, Tools.RISCVsema.arithmetic_r.Opcode.slt));
        break;
      case sgt:
        ret.add(new arithmetic_r(r0, r2, r1, Tools.RISCVsema.arithmetic_r.Opcode.slt));
        break;
      case sle:
        ret.add(new arithmetic_r(r0, r2, r1, Tools.RISCVsema.arithmetic_r.Opcode.slt));
        ret.add(new arithmetic_i(r0, r0, new immnum(1), Tools.RISCVsema.arithmetic_i.Opcode.xori));
        break;
      case sge:
        ret.add(new arithmetic_r(r0, r1, r2, Tools.RISCVsema.arithmetic_r.Opcode.slt));
        ret.add(new arithmetic_i(r0, r0, new immnum(1), Tools.RISCVsema.arithmetic_i.Opcode.xori));
        break;
    }
    ret.addAll(regAlloc.StorePhyReg(r0, regAlloc.GetVirtReg(dest)));
    return ret;
  }

  @Override
  public void rename(HashMap<register, Entity> renameMap) {
    if (src1 instanceof register && renameMap.containsKey(src1)) {
      src1 = renameMap.get(src1);
    }
    if (src2 instanceof register && renameMap.containsKey(src2)) {
      src2 = renameMap.get(src2);
    }
  }
  
  @Override
  public void initialize() {
    if (src1 instanceof register) {
      if (!((register) src1).isGlobal) {
        liveVarIn.add((register) src1);
      }
    }
    if (src2 instanceof register) {
      if (!((register) src2).isGlobal) {
        liveVarIn.add((register) src2);
      }
    }
    if (!dest.isGlobal) {
      liveVarOut.add(dest);
    }
  }
}
