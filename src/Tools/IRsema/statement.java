package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import Tools.Pair;

import Tools.Entity;
import Tools.RISCVsema.command;
import codegen.RegAlloca;

abstract public class statement {
  public HashSet<register> liveVarIn, liveVarOut;
  public HashSet<register> defVar;
  boolean hasChecked = false;
  boolean isDead = true;

  public statement() {
    liveVarIn = new HashSet<>();
    liveVarOut = new HashSet<>();
    defVar = new HashSet<>();
  }

  public boolean checkLive(HashSet<register> successorIn) {
    int prevSize = liveVarOut.size();
    liveVarOut.addAll(successorIn);
    if (liveVarOut.size() == prevSize && hasChecked) {
      return false;
    }
    HashSet<register> tmp = new HashSet<>(liveVarOut);
    tmp.removeAll(defVar);
    liveVarIn.addAll(tmp);
    hasChecked = true;
    return true;
  }

  abstract public void print(PrintStream out);

  abstract public ArrayList<command> toasm(RegAlloca regAlloc);

  abstract public void rename(HashMap<register, Entity> renameMap);

  abstract public void initialize();

  abstract public Pair<Boolean, statement> propagate();
}
