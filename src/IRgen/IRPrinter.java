package IRgen;

import java.io.PrintStream;

import Tools.globalscope;
import Tools.Class;
import Tools.Type;

public class IRPrinter {
  private PrintStream out;

  globalscope gscope;
  
  public IRPrinter(globalscope gscope, PrintStream out) {
    this.gscope = gscope;
    this.out = out;
  }

  public void print() {
    for (String keySet : gscope.classes.keySet()) {
      Class c = gscope.classes.get(keySet);
      out.print("%class." + keySet + " = type {");
      for (Type : c.members.values()) {
        
      }
    }
  }
}
