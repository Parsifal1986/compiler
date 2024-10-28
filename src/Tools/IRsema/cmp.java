package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import Tools.Entity;
import Tools.RISCVsema.arithmetic_i;
import Tools.RISCVsema.arithmetic_r;
import Tools.RISCVsema.command;
import Tools.RISCVsema.Pseudoinstruction.li;
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
  public ArrayList<command> toasm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    phyreg r0 = regAlloc.GetPhyReg(dest, 0), r1 = regAlloc.GetPhyReg(src1, 0), r2 = regAlloc.GetPhyReg(src2, 1);
    if (src1 instanceof constant1 || src1 instanceof constant32) {
      int lval;
      if (src1 instanceof constant1) {
        lval = ((constant1) src1).value ? 1 : 0;
      } else {
        lval = ((constant32) src1).value;
      }
      if (src2 instanceof constant1 || src2 instanceof constant32) {
        int rval;
        if (src2 instanceof constant1) {
          rval = ((constant1) src2).value ? 1 : 0;
        } else {
          rval = ((constant32) src2).value;
        }
        switch (op) {
          case eq:
            ret.add(new li(r0, new immnum(lval == rval ? 1 : 0)));
            break;
          case ne:
            ret.add(new li(r0, new immnum(lval != rval ? 1 : 0)));
            break;
          case slt:
            ret.add(new li(r0, new immnum(lval < rval ? 1 : 0)));
            break;
          case sgt:
            ret.add(new li(r0, new immnum(lval > rval ? 1 : 0)));
            break;
          case sle:
            ret.add(new li(r0, new immnum(lval <= rval ? 1 : 0)));
            break;
          case sge:
            ret.add(new li(r0, new immnum(lval >= rval ? 1 : 0)));
            break;
        }
      } else {
        ret.addAll(regAlloc.LoadToPhyReg(r2, src2));
        switch (op) {
          case eq:
            if (0 <= lval && lval < 4096) {
              ret.add(new arithmetic_i(r0, r2, new immnum(lval), Tools.RISCVsema.arithmetic_i.Opcode.xori));
              ret.add(new arithmetic_i(r0, r0, new immnum(1), Tools.RISCVsema.arithmetic_i.Opcode.sltiu));
            } else {
              ret.addAll(regAlloc.LoadToPhyReg(r1, src1));
              ret.add(new arithmetic_r(r0, r2, r1, Tools.RISCVsema.arithmetic_r.Opcode.xor));
              ret.add(new arithmetic_i(r0, r0, new immnum(1), Tools.RISCVsema.arithmetic_i.Opcode.sltiu));
            }
            break;
          case ne:
            if (0 <= lval && lval < 4096) {
              ret.add(new arithmetic_i(r0, r2, new immnum(lval), Tools.RISCVsema.arithmetic_i.Opcode.xori));
            } else {
              ret.addAll(regAlloc.LoadToPhyReg(r1, src1));
              ret.add(new arithmetic_r(r0, r1, r2, Tools.RISCVsema.arithmetic_r.Opcode.xor));
            }
            break;
          case slt:
            ret.addAll(regAlloc.LoadToPhyReg(r1, src1));
            ret.add(new arithmetic_r(r0, r1, r2, Tools.RISCVsema.arithmetic_r.Opcode.slt));
            break;
          case sgt:
            if (-2048 <= lval && lval < 2048) {
              ret.add(new arithmetic_i(r0, r2, new immnum(lval), Tools.RISCVsema.arithmetic_i.Opcode.slti));
            } else {
              ret.addAll(regAlloc.LoadToPhyReg(r1, src1));
              ret.add(new arithmetic_r(r0, r2, r1, Tools.RISCVsema.arithmetic_r.Opcode.slt));
            }
            break;
          case sle:
            if (-2048 <= lval && lval < 2048) {
              ret.add(new arithmetic_i(r0, r2, new immnum(lval), Tools.RISCVsema.arithmetic_i.Opcode.slti));
              ret.add(new arithmetic_i(r0, r0, new immnum(1), Tools.RISCVsema.arithmetic_i.Opcode.xori));
            } else {
              ret.addAll(regAlloc.LoadToPhyReg(r1, src1));
              ret.add(new arithmetic_r(r0, r2, r1, Tools.RISCVsema.arithmetic_r.Opcode.slt));
              ret.add(new arithmetic_i(r0, r0, new immnum(1), Tools.RISCVsema.arithmetic_i.Opcode.xori));
            }
            break;
          case sge:
            ret.addAll(regAlloc.LoadToPhyReg(r1, src1));
            ret.add(new arithmetic_r(r0, r1, r2, Tools.RISCVsema.arithmetic_r.Opcode.slt));
            ret.add(new arithmetic_i(r0, r0, new immnum(1), Tools.RISCVsema.arithmetic_i.Opcode.xori));
            break;
        }
      }
    } else {
      ret.addAll(regAlloc.LoadToPhyReg(r1, src1));
      if (src2 instanceof constant1 || src2 instanceof constant32) {
        int rval;
        if (src2 instanceof constant1) {
          rval = ((constant1) src2).value ? 1 : 0;
        } else {
          rval = ((constant32) src2).value;
        }
        switch (op) {
          case eq:
            if (0 <= rval && rval < 4096) {
              ret.add(new arithmetic_i(r0, r1, new immnum(rval), Tools.RISCVsema.arithmetic_i.Opcode.xori));
              ret.add(new arithmetic_i(r0, r0, new immnum(1), Tools.RISCVsema.arithmetic_i.Opcode.sltiu));
            } else {
              ret.addAll(regAlloc.LoadToPhyReg(r2, src2));
              ret.add(new arithmetic_r(r0, r1, r2, Tools.RISCVsema.arithmetic_r.Opcode.xor));
              ret.add(new arithmetic_i(r0, r0, new immnum(1), Tools.RISCVsema.arithmetic_i.Opcode.sltiu));
            }
            break;
          case ne:
            if (0 <= rval && rval < 4096) {
              ret.add(new arithmetic_i(r0, r1, new immnum(rval), Tools.RISCVsema.arithmetic_i.Opcode.xori));
            } else {
              ret.addAll(regAlloc.LoadToPhyReg(r2, src2));
              ret.add(new arithmetic_r(r0, r1, r2, Tools.RISCVsema.arithmetic_r.Opcode.xor));
            }
            break;
          case slt:
            if (-2048 <= rval && rval < 2048) {
              ret.add(new arithmetic_i(r0, r1, new immnum(rval), Tools.RISCVsema.arithmetic_i.Opcode.slti));
            } else {
              ret.addAll(regAlloc.LoadToPhyReg(r2, src2));
              ret.add(new arithmetic_r(r0, r1, r2, Tools.RISCVsema.arithmetic_r.Opcode.slt));
            }
            break;
          case sgt:
            ret.addAll(regAlloc.LoadToPhyReg(r2, src2));
            ret.add(new arithmetic_r(r0, r2, r1, Tools.RISCVsema.arithmetic_r.Opcode.slt));
            break;
          case sle:
            ret.addAll(regAlloc.LoadToPhyReg(r2, src2));
            ret.add(new arithmetic_r(r0, r2, r1, Tools.RISCVsema.arithmetic_r.Opcode.slt));
            ret.add(new arithmetic_i(r0, r0, new immnum(1), Tools.RISCVsema.arithmetic_i.Opcode.xori));
            break;
          case sge:
            if (-2048 <= rval && rval < 2048) {
              ret.add(new arithmetic_i(r0, r1, new immnum(rval), Tools.RISCVsema.arithmetic_i.Opcode.slti));
              ret.add(new arithmetic_i(r0, r0, new immnum(1), Tools.RISCVsema.arithmetic_i.Opcode.xori));
            } else {
              ret.addAll(regAlloc.LoadToPhyReg(r2, src2));
              ret.add(new arithmetic_r(r0, r1, r2, Tools.RISCVsema.arithmetic_r.Opcode.slt));
              ret.add(new arithmetic_i(r0, r0, new immnum(1), Tools.RISCVsema.arithmetic_i.Opcode.xori));
            }
            break;
            default:
              break;
          }
      } else {
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
      }
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
      defVar.add(dest);
    }
  }
}
