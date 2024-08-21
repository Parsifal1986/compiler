package IRgen;

import java.io.PrintStream;
import java.util.ArrayList;

import Tools.IRsema.declaration;
import Tools.IRsema.func;

public class IRPrinter {
  private PrintStream out;
  private ArrayList<func> functons;

  declaration decl;
  
  public IRPrinter(declaration decl, PrintStream out, ArrayList<func> functons) {
    this.decl = decl;
    this.out = out;
    this.functons = functons;
  }

  public void print() {
    decl.print(out);

    for (func functons : functons) {
      functons.visit(out);
      out.println();
    }
  }
}
