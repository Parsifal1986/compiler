package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;

import Tools.Entity;
import Tools.RISCVsema.command;
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
  public ArrayList<command> toAsm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    ret.addAll(regAlloc.LoadToPhyReg(regAlloc.GetPhyReg("t0"), rhs));
    ret.addAll(regAlloc.StorePhyReg(regAlloc.GetPhyReg("t0"), regAlloc.GetVirtReg(lhs)));
    return ret;
  }
}
