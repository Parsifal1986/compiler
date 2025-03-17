package codegen;

import java.util.ArrayList;

import Tools.IRsema.func;

public class ConstPropagator {
  private ArrayList<func> functions;

  public ConstPropagator(ArrayList<func> functions) {
    this.functions = functions;
  }

  public void propagate() {
    for (func functions : functions) {
      functions.propagate();
    }
  }
}
