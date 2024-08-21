package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import Tools.Class;
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
      for (int i = 0; i < c.vtable.size(); i++) {
        String type = gscope.GetIRClass(c.vtable.get(i));
        if (type == "i1") {
          out.print("i1, [7 x i1], [3 x i8]");
        } else if (c.vtable.get(i).getDim() == 0 && c.vtable.get(i).getfinaltype().equals(c.name)) {
          out.print("ptr");
        } else {
          out.print(type);
        }
        if (i != c.vtable.size() - 1) {
          out.print(", ");
        }
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
    out.println("declare i32 @string.length(ptr)");
    out.println("declare ptr @string.substring(i32, i32, ptr)");
    out.println("declare i32 @string.parseInt(ptr)");
    out.println("declare i32 @string.ord(i32, ptr)");
    out.println("declare ptr @string.add(ptr, ptr)");
    out.println("declare ptr @string.eq(ptr, ptr)");
    out.println("declare ptr @string.ne(ptr, ptr)");
    out.println("declare ptr @string.lt(ptr, ptr)");
    out.println("declare ptr @string.gt(ptr, ptr)");
    out.println("declare ptr @string.le(ptr, ptr)");
    out.println("declare ptr @string.ge(ptr, ptr)");
    out.println("declare ptr @newarray(i32, i32)");
    out.println("declare i32 @_array.size(ptr)");
    out.println("declare ptr @malloc(i32)");
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
