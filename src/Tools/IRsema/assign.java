package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;

import Tools.Entity;
import Tools.RISCVsema.command;
import Tools.RISCVsema.memory_s;
import Tools.RISCVsema.operand.immnum;
import Tools.RISCVsema.operand.phyreg;
import codegen.RegAlloca;

public class assign extends statement {
  public register left;
  public Entity right;

  public assign(register left, Entity right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public void print(PrintStream out) {
    out.println("store " + right.type + " " + right.tostring() + ", " + left.type + " "+ left.tostring());
  }

  @Override
  public ArrayList<command> toAsm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    phyreg data = regAlloc.GetPhyReg("t0");
    phyreg addr = regAlloc.GetPhyReg("t1");
    ret.addAll(regAlloc.LoadToPhyReg(addr, left));
    ret.addAll(regAlloc.LoadToPhyReg(data, right));
    ret.add(new memory_s(addr, data, new immnum(0), memory_s.Opcode.SW));
    return ret;
  }
}
