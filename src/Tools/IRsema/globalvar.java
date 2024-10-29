package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import Tools.Entity;
import Tools.RISCVsema.command;
import codegen.RegAlloca;

public class globalvar extends statement {
  public register reg;
  public String type;

  public globalvar(register reg, String type) {
    this.reg = reg;
    this.type = type;
  }
  
  @Override
  public void print(PrintStream out) {
    out.println(reg.tostring() + " = global " + type + " zeroinitializer");
  }

  @Override
  public ArrayList<command> toasm(RegAlloca regAlloc) {
    return null;
  }

  @Override
  public void rename(HashMap<register, Entity> renameMap) {
    return;
  }

  @Override
  public void initialize() {
    return;
  }
}
