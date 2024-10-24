package Tools.RISCVsema.section;

import java.io.PrintStream;

public class rodatasection extends asmsection {
  String data;

  public rodatasection(String data, String name, boolean isGlobal) {
    this.data = data;
    this.name = name;
    this.isGlobal = isGlobal;
  }
  
  @Override
  public void print(PrintStream out) {
    out.println(".rodata");
    if (isGlobal) {
      out.println(".globl ");
    }
    out.println(".align 2");
    out.println(name + ":");
    out.println("  .asciz " + "\"" + data + "\"");
  }
}
