package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class func {
  public String name;
  public String type;
  public ArrayList<String> args;
  public ArrayList<register> entry;
  public block headblock;

  public func() {
    entry = new ArrayList<register>();
    args = new ArrayList<String>();
  }

  public void visit(PrintStream out) {
    out.println("define " + type + " @" + name + "(" + String.join(", ", args) + ") {");
    if (entry.size() > 0) {
      out.println("entry:");
      entry.forEach(
        reg -> out.println("\t" + reg.tostring() + " = alloca " + reg.type)
      );
    }
    Queue<block> q = new LinkedList<block>();
    q.add(headblock);
    while (q.size() > 0) {
      block current = q.poll();
      if (current.isprint) {
        continue;
      }
      current.isprint = true;
      out.println(current.name + ":");
      if (current.statements.size() > 0) {
        for (statement s : current.statements) {
          out.print("\t");
          s.print(out);
        }
      }
      if (current.next != null) {
        out.print("\t");
        current.next.print(out);
        current.next.next().forEach(q::add);  
      } else {
        if (name == "main") {
          out.println("\tret i32 0");
        } else {
          out.println("\tret void");
        }
      }
    }
    out.println("}");
  }
}
