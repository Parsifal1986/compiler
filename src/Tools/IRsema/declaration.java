package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import Tools.Class;
import Tools.globalscope;
import Tools.RISCVsema.section.asmsection;
import Tools.RISCVsema.section.bsssection;
import Tools.RISCVsema.section.rodatasection;

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
    out.println("declare ptr @booltoString(i1)");
    out.println();
    for (statement s : global) {
      s.print(out);
    }
    out.println();
  }

  public ArrayList<asmsection> trans() {
    ArrayList<asmsection> res = new ArrayList<asmsection>();
    for (statement s : global) {
      if (s instanceof stringconst) {
        stringconst sc = (stringconst)s;
        rodatasection rodata = new rodatasection(sc.initialize, sc.reg.name, false);
        // rodatasection rodata = new rodatasection(sc.initialize, ".L" + sc.reg.name, false);
        // datasection data = new datasection(new immtag(".L" + sc.reg.name, immtag.range.FULL), sc.reg.name, true, datasection.classtype.WORD);
        res.add(rodata);
        // res.add(data);
      } else if (s instanceof globalvar) {
        globalvar gv = (globalvar)s;
        bsssection bss = new bsssection(gv.type.equals("i1") ? 1 : 4, gv.reg.name, true);
        // datasection data = new datasection(new immtag(".D" + gv.reg.name, immtag.range.FULL), gv.reg.name, true, datasection.classtype.WORD);
        res.add(bss);
        // res.add(data);
      }
    }
    return res;
  }
}
