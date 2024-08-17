package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;

import Tools.Entity;

public class getelementptr extends statement {
  public String type;
  public register reg;
  public register ptr;
  public ArrayList<Entity> index;

  public getelementptr(String type, register reg, register ptr, ArrayList<Entity> index) {
    this.type = type;
    this.reg = reg;
    this.ptr = ptr;
    this.index = index;
  }

  @Override
  public void print(PrintStream out) {
    out.print(reg.tostring() + " = getelementptr inbounds " + type + ", " + ptr.type + " " + ptr.tostring() + ", ");
    for (int i = 0; i < index.size(); i++) {
      out.print(index.get(i).type + " " + index.get(i).tostring());
      if (i != index.size() - 1) {
        out.print(", ");
      }
    }
    out.println();
  }
}
