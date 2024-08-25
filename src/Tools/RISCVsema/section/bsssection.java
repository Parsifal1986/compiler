package Tools.RISCVsema.section;

import java.io.PrintStream;

public class bsssection extends asmsection {
  int size = -1;
  
  public bsssection(int size, String name, boolean isGlobal) {
    this.size = size;
    this.name = name;
    this.isGlobal = isGlobal;
  }

  @Override
  public void print(PrintStream out) {
    out.println(".bss");
    if (isGlobal) {
      out.println(".globl " + name);
    }
    out.println(".align 2");
    out.println(name + ":");
    out.println(".zero " + size);
  }
}
