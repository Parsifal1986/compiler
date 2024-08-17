package Tools.IRsema;

import java.io.PrintStream;

public class alloca extends statement {
  public register reg;
  public String type;

  public alloca(register reg, String type) {
    this.reg = reg;
    this.type = type;
  }

  @Override
  public void print(PrintStream out) {
    out.println(reg.tostring() + " = alloca " + type);
  }
}
