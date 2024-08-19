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
      if (keySet == "int" || keySet == "bool" || keySet == "_array" || keySet == "string") {
        continue;
      }
      Class c = gscope.classes.get(keySet);
      out.print("%class." + keySet + " = type { ");
      for (Type vtable : c.vtable) {
        out.print(vtable.ToIrType() + ", ");
      }
      out.println("}");
    }
    out.println();
    out.println("declare void @print(ptr)");
    out.println("declare void @println(ptr)");
    out.println("declare void @printInt(i32)");
    out.println("declare void @printlnInt(i32)");
    out.println("declare ptr @getString()");
    out.println("declare i32 @getInt()");
    out.println("declare ptr @toString(i32)");
    out.println();
    // for (String keySet : gscope.functions.keySet()) {
    //   out.print("declare " + gscope.functions.get(keySet).ToIrType() + " @" + gscope.functionrename.get(keySet) + "(");
    //   for (int i = 0; i < gscope.funcparams.get(keySet).size(); i++) {
    //     out.print(gscope.funcparams.get(keySet).get(i).ToIrType() + " %." + gscope.funcparams.get(keySet).get(i).ToIrType());
    //     if (i != gscope.funcparams.get(keySet).size() - 1) {
    //       out.print(", ");
    //     }
    //   }
    //   out.println(")");
    // }
    // for (Class values : gscope.classes.values()) {
    //   for (String keySet : values.functions.keySet()) {
    //     out.print("declare " + values.functions.get(keySet).ToIrType() + " @" + values.functionrename.get(keySet) + "(");
    //     for (int i = 0; i < values.funcparams.get(keySet).size(); i++) {
    //       out.print(values.funcparams.get(keySet).get(i).ToIrType() + " %." + values.funcparams.get(keySet).get(i).ToIrType());
    //       if (i != values.funcparams.get(keySet).size() - 1) {
    //         out.print(", ");
    //       }
    //     }
    //     out.println(")");
    //   }
    // }
    // for (Class values : gscope.classes.values()) {
    //   for (String values2 : values.functionrename.values()) {
    //     out.println("$" + values2 + "() = comdat any");
    //   }
    // }
    out.println();
    for (statement s : global) {
      s.print(out);
    }
    out.println();
  }
}
