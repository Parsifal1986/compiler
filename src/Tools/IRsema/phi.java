package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;

import Tools.Entity;
import Tools.RISCVsema.command;
import codegen.RegAlloca;

public class phi extends statement {
  public register dst;
  public Entity src1;
  public Entity src2;
  public String label1;
  public String label2;

  public phi(register dst, Entity src1, Entity src2, String label1, String label2) {
    this.dst = dst;
    this.src1 = src1;
    this.src2 = src2;
    this.label1 = label1;
    this.label2 = label2;
  }

  @Override
  public void print(PrintStream out) {
    out.println(dst.tostring() + " = phi " + dst.type + " [" + src1.tostring() + ", %" + label1 + "], [" + src2.tostring() + ", %" + label2 + "]");
  }

  @Override
  public ArrayList<command> toAsm(RegAlloca regAlloc) {
    return null;
  }
}
