package Tools.IRsema;

import java.io.PrintStream;

public class arrayInit extends statement {
  register reg;
  int size;
  String type;
  String initialize;

  public arrayInit(register reg, int size, String type, String initialize) {
    this.reg = reg;
    this.size = size;
    this.type = type;
    this.initialize = initialize;
  }
  
  @Override
  public void print(PrintStream out) {
    out.println(reg.tostring(true) + " = alloca [" + size + " x " + type + "]");
  }
  
}
