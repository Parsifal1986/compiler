package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;

import Tools.Entity;
import Tools.RISCVsema.arithmetic_r;
import Tools.RISCVsema.command;
import Tools.RISCVsema.operand.phyreg;
import codegen.RegAlloca;

public class binary extends statement {
  public opcode op;
  public Entity lhs;
  public Entity rhs;
  public register result;

  public binary(opcode op, Entity lhs, Entity rhs, register result) {
    this.op = op;
    this.lhs = lhs;
    this.rhs = rhs;
    this.result = result;
  }

  @Override
  public void print(PrintStream out) {
    out.println(result.tostring() + " = " + op + " " + lhs.type + " " + lhs.tostring() + ", " + rhs.tostring());
  }
  
  public enum opcode {
    add, sub, mul, sdiv, srem, shl, ashr, and, or, xor
  }

  @Override
  public ArrayList<command> toAsm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    phyreg r0 = regAlloc.GetPhyReg("t0"), r1 = regAlloc.GetPhyReg("t1"), r2 = regAlloc.GetPhyReg("t2");
    ret.addAll(regAlloc.LoadToPhyReg(r1, lhs));
    ret.addAll(regAlloc.LoadToPhyReg(r2, rhs));
    switch (op) {
      case add:
        ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.add));
        break;
      case sub:
        ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.sub));
        break;
      case mul:
        ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.mul));
        break;
      case sdiv:
        ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.div));
        break;
      case srem:
        ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.rem));
        break;
      case shl:
        ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.sll));
        break;
      case ashr:
        ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.sra));
        break;
      case and:
        ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.and));
        break;
      case or:
        ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.or));
        break;
      case xor:
        ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.xor));
        break;
      default:
        break;
    }
    ret.addAll(regAlloc.StorePhyReg(r0, regAlloc.GetVirtReg(result)));
    return ret;
  }
}
