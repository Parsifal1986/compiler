package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import Tools.Pair;

import Tools.Entity;
import Tools.RISCVsema.command;
import Tools.RISCVsema.operand.phyreg;
import codegen.RegAlloca;

public class trans extends statement {
  public register dst;
  public Entity src;

  public trans(register dst, Entity src) {
    this.dst = dst;
    this.src = src;
  }
  
  @Override
  public void print(PrintStream out) {
    out.println(dst.tostring() + " = " + "trunc " + src.type + " " + src.tostring() + " to " + dst.type);
  }

  @Override
  public ArrayList<command> toasm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    phyreg r0;
    if (src instanceof register) {
      r0 = regAlloc.GetPhyReg(regAlloc.GetVirtReg((register) src));
    } else {
      r0 = regAlloc.GetPhyReg("t0");
    }
    ret.addAll(regAlloc.LoadToPhyReg(r0, src));
    ret.addAll(regAlloc.StorePhyReg(r0, regAlloc.GetVirtReg(dst)));
    return ret;
  }

  @Override
  public void rename(HashMap<register, Entity> renameMap) {
    return;
  }

  @Override
  public Pair<Boolean, statement> propagate() {
    if (src instanceof register) {
      if (!((register) src).isConst) {
        dst.isConst = true;
        dst.value = ((register) src).value;
      }
    }
    return new Pair<Boolean, statement>(false, this);
  }

  @Override
  public void initialize() {
    if (src instanceof register) {
      if (!((register) src).isGlobal) {
        liveVarIn.add((register) src);
      }
    }
    if (!dst.isGlobal) {
      defVar.add(dst);
    }
  }
}
