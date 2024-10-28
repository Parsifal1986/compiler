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
    phyreg r0 = regAlloc.GetPhyReg(result, 0), r1 = regAlloc.GetPhyReg(lhs, 0), r2 = regAlloc.GetPhyReg(rhs, 1);
    if (lhs instanceof constant1 || lhs instanceof constant32) {
      if (rhs instanceof constant1 || rhs instanceof constant32) {
        int lval, rval;
        if (lhs instanceof constant1) {
          lval = ((constant1) lhs).value ? 1 : 0;
        } else {
          lval = ((constant32) lhs).value;
        }
        if (rhs instanceof constant1) {
          rval = ((constant1) rhs).value ? 1 : 0;
        } else {
          rval = ((constant32) rhs).value;
        }
        switch (op) {
          case add:
            ret.add(new li(r0, new immnum(lval + rval)));
            break;
          case sub:
            ret.add(new li(r0, new immnum(lval - rval)));
            break;
          case mul:
            ret.add(new li(r0, new immnum(lval * rval)));
            break;
          case sdiv:
            if (rval == 0) {
              ret.addAll(regAlloc.LoadToPhyReg(r2, rhs));
              ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.div));
              break;
            }
            ret.add(new li(r0, new immnum(lval / rval)));
            break;
          case srem:
            if (rval == 0) {
              ret.addAll(regAlloc.LoadToPhyReg(r2, rhs));
              ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.rem));
              break;
            }
            ret.add(new li(r0, new immnum(lval % rval)));
            break;
          case shl:
            ret.add(new li(r0, new immnum(lval << rval)));
            break;
          case ashr:
            ret.add(new li(r0, new immnum(lval >> rval)));
            break;
          case and:
            ret.add(new li(r0, new immnum(lval & rval)));
            break;
          case or:
            ret.add(new li(r0, new immnum(lval | rval)));
            break;
          case xor:
            ret.add(new li(r0, new immnum(lval ^ rval)));
            break;
          default:
            break;
        }
      } else {
        ret.addAll(regAlloc.LoadToPhyReg(r2, rhs));
        int lval;
        if (lhs instanceof constant1) {
          lval = ((constant1) lhs).value ? 1 : 0;
        } else {
          lval = ((constant32) lhs).value;
        }
        switch (op) {
          case add:
            if (-2048 <= lval && lval < 2048) {
              ret.add(new arithmetic_i(r0, r2, new immnum(lval), arithmetic_i.Opcode.addi));
            } else {
              ret.addAll(regAlloc.LoadToPhyReg(r1, lhs));
              ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.add));
            }
            break;
          case sub:
            ret.addAll(regAlloc.LoadToPhyReg(r1, lhs));
            ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.sub));
            break;
          case mul:
            ret.addAll(regAlloc.LoadToPhyReg(r1, lhs));
            ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.mul));
            break;
          case sdiv:
            ret.addAll(regAlloc.LoadToPhyReg(r1, lhs));
            ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.div));
            break;
          case srem:
            ret.addAll(regAlloc.LoadToPhyReg(r1, lhs));
            ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.rem));
            break;
          case shl:
            ret.addAll(regAlloc.LoadToPhyReg(r1, lhs));
            ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.sll));
            break;
          case ashr:
            ret.addAll(regAlloc.LoadToPhyReg(r1, lhs));
            ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.sra));
            break;
          case and:
            if (0 < lval && lval < 4096) {
              ret.add(new arithmetic_i(r0, r2, new immnum(lval), arithmetic_i.Opcode.andi));
            } else {
              ret.addAll(regAlloc.LoadToPhyReg(r1, lhs));
              ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.and));
            }
            break;
          case or:
            if (0 < lval && lval < 4096) {
              ret.add(new arithmetic_i(r0, r2, new immnum(lval), arithmetic_i.Opcode.ori));
            } else {
              ret.addAll(regAlloc.LoadToPhyReg(r1, lhs));
              ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.or));
            }
            break;
          case xor:
            if (0 < lval && lval < 4096) {
              ret.add(new arithmetic_i(r0, r2, new immnum(lval), arithmetic_i.Opcode.xori));
            } else {
              ret.addAll(regAlloc.LoadToPhyReg(r1, lhs));
              ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.xor));
            }
            break;
          default:
            break;
        }
      }
    } else {
      ret.addAll(regAlloc.LoadToPhyReg(r1, lhs));
      if (rhs instanceof constant1 || rhs instanceof constant32) {
        int rval;
        if (rhs instanceof constant1) {
          rval = ((constant1) rhs).value ? 1 : 0;
        } else {
          rval = ((constant32) rhs).value;
        }
        switch (op) {
          case add:
          if (-2048 <= rval && rval < 2048) {
            ret.add(new arithmetic_i(r0, r1, new immnum(rval), arithmetic_i.Opcode.addi));
          } else {
            ret.addAll(regAlloc.LoadToPhyReg(r2, rhs));
            ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.add));
          }
          break;
        case sub:
          if (-2048 < rval && rval <= 2048) {
            ret.add(new arithmetic_i(r0, r1, new immnum(-rval), arithmetic_i.Opcode.addi));
          } else {
            ret.addAll(regAlloc.LoadToPhyReg(r2, rhs));
            ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.sub));
          }
          break;
        case mul:
          ret.addAll(regAlloc.LoadToPhyReg(r2, rhs));
          ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.mul));
          break;
        case sdiv:
          ret.addAll(regAlloc.LoadToPhyReg(r2, rhs));
          ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.div));
          break;
        case srem:
          ret.addAll(regAlloc.LoadToPhyReg(r2, rhs));
          ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.rem));
          break;
        case shl:
          if (0 < rval && rval < 4096) {
            ret.add(new arithmetic_i(r0, r1, new immnum(rval), arithmetic_i.Opcode.slli));
          } else {
            ret.addAll(regAlloc.LoadToPhyReg(r2, rhs));
            ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.sll));
          }
          break;
        case ashr:
          if (0 < rval && rval < 4096) {
            ret.add(new arithmetic_i(r0, r1, new immnum(rval), arithmetic_i.Opcode.srai));
          } else {
            ret.addAll(regAlloc.LoadToPhyReg(r2, rhs));
            ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.sra));
          }
          break;
        case and:
          if (0 < rval && rval < 4096) {
            ret.add(new arithmetic_i(r0, r1, new immnum(rval), arithmetic_i.Opcode.andi));
          } else {
            ret.addAll(regAlloc.LoadToPhyReg(r2, rhs));
            ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.and));
          }
          break;
        case or:
          if (0 < rval && rval < 4096) {
            ret.add(new arithmetic_i(r0, r1, new immnum(rval), arithmetic_i.Opcode.ori));
          } else {
            ret.addAll(regAlloc.LoadToPhyReg(r2, rhs));
            ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.or));
          }
          break;
        case xor:
          if (0 < rval && rval < 4096) {
            ret.add(new arithmetic_i(r0, r1, new immnum(rval), arithmetic_i.Opcode.xori));
          } else {
            ret.addAll(regAlloc.LoadToPhyReg(r2, rhs));
            ret.add(new arithmetic_r(r0, r1, r2, arithmetic_r.Opcode.xor));
          }
          break;
        default:
          break;
      }
    } else {
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
      }
    }
    ret.addAll(regAlloc.StorePhyReg(r0, regAlloc.GetVirtReg(result)));
    return ret;
  }

  @Override
  public void rename(HashMap<register, Entity> renameMap) {
    if (renameMap.containsKey(lhs)) {
      lhs = renameMap.get(lhs);
    }
    if (renameMap.containsKey(rhs)) {
      rhs = renameMap.get(rhs);
    }
  }

  @Override
  public void initialize() {
    if (lhs instanceof register) {
      if (!((register) lhs).isGlobal) {
        liveVarIn.add((register) lhs);
      }
    }
    if (rhs instanceof register) {
      if (!((register) rhs).isGlobal) {
        liveVarIn.add((register) rhs);
      }
    }
    if (!result.isGlobal) {
      defVar.add(result);
    }
  }
}
