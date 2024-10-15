package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import Tools.Entity;
import Tools.RISCVsema.command;
import codegen.RegAlloca;

public class stringconst extends statement {
  register reg;
  int size;
  String type;
  String initialize;

  public stringconst(register reg, int size, String type, String initialize) {
    this.reg = reg;
    this.size = size;
    this.type = type;
    this.initialize = initialize;
  }
  
  @Override
  public void print(PrintStream out) {
    out.println(reg.tostring() + " = private unnamed_addr constant [" + size + " x " + type + "] c\"" + initialize + "\0\"");
  }
  
  @Override
  public ArrayList<command> toAsm(RegAlloca regAlloc) {
    return null;
  }

  @Override
  public void rename(HashMap<register, Entity> renameMap) {
    return;
  }

  @Override
  public void initialize() {
    defVar.add(reg);
  }
}
