package codegen;

import java.util.ArrayList;

import Tools.IRsema.func;

public class PhiCleaner {
  private ArrayList<func> functions;

  public PhiCleaner(ArrayList<func> functions) {
    this.functions = functions;
  }
  
  public void CleanPhi() {
    for (func functions : functions) {
      functions.clean_phi();
    }
  }
}
