package Tools.IRsema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class block {
  public String name;
  public ArrayList<statement> statements = new ArrayList<>();
  public control next;
  public static int cnt = 0;
  public boolean isprint = false;
  public boolean istrans = false;
  public boolean isclean = false;
  public boolean ismem2reg = false;
  public boolean isrename = false;
  public HashSet<block> pre = new HashSet<>();
  public ArrayList<block> e = new ArrayList<>();
  public HashSet<block> frontier = new HashSet<>();
  public ArrayList<phi> phisInOrder = new ArrayList<>();
  public HashMap<register, phi> phis = new HashMap<>();
  public HashMap<register, phi> allPhis = new HashMap<>();
  public HashMap<block, block> tmpBlocks = new HashMap<>();

  public block newblock(String name) {
    block tmp = new block(name);
    next = new branch(null, tmp, null);
    return tmp;
  }

  public block(String name) {
    if (name == null) {
      return;
    }
    this.name = name + (cnt++);
  }

  public void add(statement s) {
    statements.add(s);
  }

  public void addInFront(statement s) {
    statements.add(0, s);
  }

  public void checkLive(HashSet<register> successorIn) {
    HashSet<register> liveOut = successorIn;
    boolean flag = true;
    if (next != null) {
      flag = next.checkLive(liveOut);
      if (!flag) {
        return;
      }
      liveOut = next.liveVarIn;
    }
    for (int i = statements.size() - 1; i >= 0; i--) {
      flag = statements.get(i).checkLive(liveOut);
      if (!flag) {
        break;
      }
      liveOut = statements.get(i).liveVarIn;
    }
    if (flag) {
      for (block pre : pre) {
        pre.checkLive(liveOut);
      }
    }
    return;
  }
}
