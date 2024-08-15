package Tools.IRsema;

import java.util.ArrayList;

import Tools.globalscope;

public class declaration {
  globalscope gscope;
  public ArrayList<String> classes;
  public ArrayList<String> func;
  public ArrayList<statement> global;

  declaration(globalscope gscope) {
    this.gscope = gscope;
  }

  public void init() {

  }
}
