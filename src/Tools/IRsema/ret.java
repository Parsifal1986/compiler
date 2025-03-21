package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import Tools.Pair;

import Tools.Entity;
import Tools.RISCVsema.command;
import codegen.RegAlloca;

public class ret extends control {
  Entity retVal;

  public ret(Entity retVal) {
    this.retVal = retVal;
  }

  @Override
  public ArrayList<block> next() {
    return new ArrayList<block>();
  }

  @Override
  public void print(PrintStream out) {
    if (retVal == null) {
      out.println("ret void");
      return;
    }
    out.println("ret " + retVal.type + " " + retVal.tostring());
  }

  @Override
  public ArrayList<command> toasm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    if (retVal != null) {
      ret.addAll(regAlloc.LoadToPhyReg(regAlloc.GetPhyReg("a0"), retVal));
    }
    ret.add(new Tools.RISCVsema.Pseudoinstruction.ret());
    return ret;
  }

  @Override
  public void rename(HashMap<register, Entity> renameMap) {
    if (retVal instanceof register) {
      if (renameMap.containsKey(retVal)) {
        retVal = renameMap.get(retVal);
      }
    }
    return;
  }

  @Override
  public Pair<Boolean, statement> propagate() {
    if (retVal instanceof register) {
      if (((register) retVal).isConst) {
        retVal = ((register) retVal).value;
      }
    }
    return new Pair<Boolean, statement>(false, this);
  }

  @Override
  public void initialize() {
    if (retVal instanceof register) {
      if (!((register) retVal).isGlobal) {
        liveVarIn.add((register) retVal);
      }
    }
  }
}
