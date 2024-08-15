package Tools.IRsema;

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

  public void print() {
  }
  
}
