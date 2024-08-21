package Tools.IRsema;

import java.io.PrintStream;

public class global extends statement {
  register reg;
  String type;

  public global(register reg, String type) {
    this.reg = reg;
    this.type = type;
  }
  
  @Override
  public void print(PrintStream out) {
    out.println(reg.tostring() + " = global " + type + " zeroinitializer");
  }
}
