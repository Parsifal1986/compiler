package Tools.IRsema;

import java.io.PrintStream;

public class global extends statement {
  register reg;

  public global(register reg) {
    this.reg = reg;
  }
  
  @Override
  public void print(PrintStream out) {
    out.println(reg.tostring() + " = global " + reg.type + " zeroinitializer");
  }
}
