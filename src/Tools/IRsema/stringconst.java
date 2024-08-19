package Tools.IRsema;

import java.io.PrintStream;

public class stringconst extends statement {
  register reg;
  int size;
  String type;
  String initialize;

  public stringconst(register reg, int size, String type, String initialize) {
    this.reg = reg;
    this.size = size;
    this.type = type;
    this.initialize = initialize;
  }
  
  @Override
  public void print(PrintStream out) {
    out.println(reg.tostring() + " = private unnamed_addr constant [" + size + " x " + type + "] c\"" + initialize + "\0\"");
  }
  
}
