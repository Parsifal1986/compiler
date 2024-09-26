package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import Tools.Entity;
import Tools.RISCVsema.command;
import codegen.RegAlloca;

abstract public class statement {
  abstract public void print(PrintStream out);

  abstract public ArrayList<command> toAsm(RegAlloca regAlloc);

  abstract public void rename(HashMap<register, Entity> renameMap);
}
