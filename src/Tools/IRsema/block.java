package Tools.IRsema;

import java.util.ArrayList;

public class block {
  public String name;
  public ArrayList<statement> statements;
  public control next;
  public static int cnt = 0;
  public boolean isprint = false;
  public boolean istrans = false;
  public boolean isclean = false;

  public block newblock(String name) {
    block tmp = new block(name);
    next = new branch(null, tmp, null);
    return tmp;
  }

  public block(String name) {
    if (name == null) {
      statements = new ArrayList<>();
      return;
    }
    this.name = name + (cnt++);
    statements = new ArrayList<statement>();
  }

  public void add(statement s) {
    statements.add(s);
  }
}
