package Tools.IRsema;

import Tools.Entity;

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
  public void print() {
    
  }
  
  public enum opcode {
    add, sub, mul, sdiv, srem, shl, ashr, and, or, xor
  }
}
