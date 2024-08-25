package Tools.RISCVsema.section;

import java.io.PrintStream;

import Tools.RISCVsema.operand.imm;

public class datasection extends asmsection {
  imm data;
  classtype type;

  public datasection(imm data, String name, boolean isGlobal, classtype type) {
    this.data = data;
    this.name = name;
    this.isGlobal = isGlobal;
    this.type = type;
  }

  @Override
  public void print(PrintStream out) {
    out.println(".data");
    if (isGlobal) {
      out.println(".globl " + name);
    }
    out.println(".align 2");
    out.println(name + ":");
    out.println("  " + type + " " + data);
  }

  public enum classtype {
    BYTE, HALF, WORD;

    @Override
    public String toString() {
      switch (this) {
        case BYTE:
          return ".byte";
        case HALF:
          return ".half";
        case WORD:
          return ".word";
        default:
          return null;
      }
    }
  }
}
