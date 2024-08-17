package Tools.IRsema;

import java.io.PrintStream;

import Tools.Entity;

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
  
}
