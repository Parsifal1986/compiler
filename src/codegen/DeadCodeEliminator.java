package codegen;

import java.util.ArrayList;

import Tools.IRsema.func;

public class DeadCodeEliminator {
  private ArrayList<func> functions;

  public DeadCodeEliminator(ArrayList<func> functions) {
    this.functions = functions;
  }
  
  public void DC_Eliminate() {
    for (func functions : functions) {
      functions.dc_elimination();
    }
  }
}
