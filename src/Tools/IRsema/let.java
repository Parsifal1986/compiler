package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import Tools.Entity;
import Tools.RISCVsema.command;
import Tools.RISCVsema.operand.phyreg;
import codegen.RegAlloca;

public class let extends statement {
  register lhs;
  Entity rhs;

  public let(register lhs, Entity rhs) {
    this.lhs = lhs;
    this.rhs = rhs;
  }

  @Override
  public void print(PrintStream out) {
    out.println(lhs.tostring() + " = " + rhs.tostring());
  }

  @Override
  public ArrayList<command> toasm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    phyreg r0;
    if (rhs instanceof register) {
      r0 = regAlloc.GetPhyReg(regAlloc.GetVirtReg((register) rhs));
    } else {
      r0 = regAlloc.GetPhyReg("t0");
    }
    ret.addAll(regAlloc.LoadToPhyReg(r0, rhs));
    ret.addAll(regAlloc.StorePhyReg(r0, regAlloc.GetVirtReg(lhs)));
    return ret;
  }

  @Override
  public void rename(HashMap<register, Entity> renameMap) {
    return;
  }

  @Override
  public void initialize() {
    if (rhs instanceof register) {
      if (!((register) rhs).isGlobal) {
        liveVarIn.add((register) rhs);
      }
    }
    if (!lhs.isGlobal) {
      defVar.add(lhs);
    }
  }
}
