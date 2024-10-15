package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import Tools.Entity;
import Tools.RISCVsema.command;
import codegen.RegAlloca;

abstract public class statement {
  public HashSet<register> liveVarIn, liveVarOut;
  public HashSet<register> defVar;

  public statement() {
    liveVarIn = new HashSet<>();
    liveVarOut = new HashSet<>();
    defVar = new HashSet<>();
  }

  public boolean checkLive(HashSet<register> successorIn) {
    int prevSize = liveVarOut.size();
    liveVarOut.addAll(successorIn);
    if (liveVarOut.size() == prevSize) {
      return false;
    }
    HashSet<register> tmp = new HashSet<>(liveVarOut);
    tmp.removeAll(defVar);
    liveVarIn.addAll(tmp);
    return true;
  }

  abstract public void print(PrintStream out);

  abstract public ArrayList<command> toAsm(RegAlloca regAlloc);

  abstract public void rename(HashMap<register, Entity> renameMap);

  abstract public void initialize();
}
