package codegen;

import java.util.ArrayList;

import Tools.IRsema.func;

public class DCE {
  private ArrayList<func> functions;

  public DCE(ArrayList<func> functions) {
    this.functions = functions;
  }
  
  public void Eliminate() {
    for (func functions : functions) {
      functions.dce();
    }
  }
}
