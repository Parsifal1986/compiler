package codegen;

import java.util.ArrayList;

import Tools.IRsema.func;

public class DivOptimizer {
  private ArrayList<func> functions;

  public DivOptimizer(ArrayList<func> functions) {
    this.functions = functions;
  }

  public void OptimizeDiv() {
    for (func functions : functions) {
      functions.optimize_div();
    }
  }
}
