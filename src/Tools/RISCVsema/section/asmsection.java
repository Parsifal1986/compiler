package Tools.RISCVsema.section;

import java.io.PrintStream;

abstract public class asmsection {
  String name;
  boolean isGlobal;

  abstract public void print(PrintStream out);
}
