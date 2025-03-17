package codegen;

import java.util.ArrayList;

import Tools.IRsema.func;

public class BranchRefiner {
  private ArrayList<func> functions;

  public BranchRefiner(ArrayList<func> functions) {
    this.functions = functions;
  }
  
  public void Refine() {
    for (func functions : functions) {
      functions.refine_branch();
    }
  }
}
