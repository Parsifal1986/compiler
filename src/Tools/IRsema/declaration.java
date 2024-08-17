package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import Tools.Class;
import Tools.Type;
import Tools.globalscope;

public class declaration {
  globalscope gscope;
  public ArrayList<statement> global;

  public declaration(globalscope gscope) {
    this.gscope = gscope;
    global = new ArrayList<statement>();
  }

  public void print(PrintStream out) {
    for (String keySet : gscope.classes.keySet()) {
      Class c = gscope.classes.get(keySet);
      out.print("%class." + keySet + " = type { ");
      for (Type vtable : c.vtable) {
        out.print(vtable.ToIrType() + ", ");
      }
      out.println("}");
    }
    out.println();
    for (Class values : gscope.classes.values()) {
      for (String values2 : values.functionrename.values()) {
        out.println("$" + values2 + "() = comdat any");
      }
    }
    out.println();
    for (statement s : global) {
      s.print(out);
    }
  }
}
