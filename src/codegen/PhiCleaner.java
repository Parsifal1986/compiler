package codegen;

import java.util.ArrayList;

import Tools.IRsema.func;

public class PhiCleaner {
  private ArrayList<func> functons;

  public PhiCleaner(ArrayList<func> functons) {
    this.functons = functons;
  }
  
  public void cleanPhi() {
    for (func functons : functons) {
      functons.cleanPhi();
    }
  }
}
