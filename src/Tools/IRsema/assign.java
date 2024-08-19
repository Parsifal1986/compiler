package Tools.IRsema;

import java.io.PrintStream;

import Tools.Entity;

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
}
