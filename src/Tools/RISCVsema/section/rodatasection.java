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
    System.out.println(".rodata");
    if (isGlobal) {
      System.out.println(".globl ");
    }
    out.println(".align 2");
    System.out.println(name + ":");
    System.out.println("  .asciz " + "\"" + data + "\"");
  }
}
