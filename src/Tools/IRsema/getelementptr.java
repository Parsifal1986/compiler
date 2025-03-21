package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import Tools.Pair;

import Tools.Entity;
import Tools.RISCVsema.arithmetic_i;
import Tools.RISCVsema.arithmetic_r;
import Tools.RISCVsema.command;
import Tools.RISCVsema.memory_i;
import Tools.RISCVsema.Pseudoinstruction.li;
import Tools.RISCVsema.Pseudoinstruction.mv;
import Tools.RISCVsema.operand.immnum;
import Tools.RISCVsema.operand.phyreg;
import codegen.RegAlloca;

public class getelementptr extends statement {
  public String type;
  public register reg;
  public Entity ptr;
  public ArrayList<Entity> index;

  public getelementptr(String type, register reg, Entity ptr, ArrayList<Entity> index) {
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
  public ArrayList<command> toasm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    phyreg t0 = regAlloc.GetPhyReg(ptr, 0);
    phyreg rd = regAlloc.GetPhyReg(reg, 0);
    phyreg t1 = regAlloc.GetPhyReg("t1");
    ret.addAll(regAlloc.LoadToPhyReg(t0, ptr));
    if (type.equals("i32") || type.equals("i8") || type.equals("ptr")) {
      for (int i = 0; i < index.size(); i++) {
        if (i != 0) {
          ret.add(new memory_i(t0, t0, new immnum(0), memory_i.Opcode.LW));
        }
        Entity idx = index.get(i);
        if (idx instanceof constant32) {
          int offset = ((constant32) idx).value;
          if (offset != 0) {
            if (offset * 4 < 2048) {
              ret.add(new arithmetic_i(rd, t0, new immnum(offset * 4), arithmetic_i.Opcode.addi));
            } else {
              ret.add(new li(t1, new immnum(offset * 4)));
              ret.add(new arithmetic_r(rd, t0, t1, arithmetic_r.Opcode.add));
            }
          } else if (rd != t0) {
            ret.add(new mv(rd, t0));
          }
        } else {
          phyreg idr = regAlloc.GetPhyReg(idx, 1);
          ret.addAll(regAlloc.LoadToPhyReg(idr, idx));
          ret.add(new arithmetic_i(t1, idr, new immnum(2), arithmetic_i.Opcode.slli));
          ret.add(new arithmetic_r(rd, t0, t1, arithmetic_r.Opcode.add));
        }
      }
    } else {
      for (int i = 1; i < index.size(); i++) {
        if (i != 1) {
          ret.add(new memory_i(t0, t0, new immnum(0), memory_i.Opcode.LW));
        }
        Entity idx = index.get(i);
        if (idx instanceof constant32) {
          int offset = ((constant32) idx).value;
          if (offset != 0) {
            if (offset * 4 < 2048) {
              ret.add(new arithmetic_i(rd, t0, new immnum(offset * 4), arithmetic_i.Opcode.addi));
            } else {
              ret.add(new li(t1, new immnum(offset * 4)));
              ret.add(new arithmetic_r(rd, t0, t1, arithmetic_r.Opcode.add));
            }
          } else if (rd != t0) {
            ret.add(new mv(rd, t0));
          }
        } else {
          phyreg idr = regAlloc.GetPhyReg(idx, 1);
          ret.addAll(regAlloc.LoadToPhyReg(idr, idx));
          ret.add(new arithmetic_i(t1, idr, new immnum(2), arithmetic_i.Opcode.slli));
          ret.add(new arithmetic_r(rd, t0, t1, arithmetic_r.Opcode.add));
        }
      }
    }
    ret.addAll(regAlloc.StorePhyReg(rd, regAlloc.GetVirtReg(reg)));
    return ret;
  }

  @Override
  public Pair<Boolean, statement> propagate() {
    for (int i = 0; i < index.size(); i++) {
      if (index.get(i) instanceof register) {
        if (((register) index.get(i)).isConst) {
          index.set(i, ((register) index.get(i)).value);
        }
      }
    }
    return new Pair<Boolean, statement>(false, this);
  }
  
  @Override
  public void rename(HashMap<register, Entity> renameMap) {
    if (renameMap.containsKey(ptr)) {
      ptr = renameMap.get(ptr);
    }
    for (int i = 0; i < index.size(); i++) {
      if (index.get(i) instanceof register && renameMap.containsKey(index.get(i))) {
        index.set(i, renameMap.get(index.get(i)));
      }
    }
  }

  @Override
  public void initialize() {
    if (ptr instanceof register) {
      if (!((register) ptr).isGlobal) {
        liveVarIn.add((register) ptr);
      }
    }
    for (Entity idx : index) {
      if (idx instanceof register) {
        if (!((register) idx).isGlobal) {
          liveVarIn.add((register) idx);
        }
      }
    }
    if (!reg.isGlobal) {
      defVar.add(reg);
    }
  }
}
