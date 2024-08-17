package Tools.IRsema;

import java.io.PrintStream;

public class load extends statement {
  register reg;
  register addr;

  public load(register reg, register addr) {
    this.reg = reg;
    this.addr = addr;
  }
  
  @Override
  public void print(PrintStream out) {
    out.println(reg.tostring() + " = load " + reg.type + ", " + addr.type + " " + addr.tostring());
  }
}
