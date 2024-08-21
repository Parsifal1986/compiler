package Tools.IRsema;

import java.io.PrintStream;

import Tools.Entity;

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
}
