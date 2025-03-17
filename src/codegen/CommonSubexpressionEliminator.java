package codegen;

import java.util.ArrayList;

import Tools.IRsema.func;

public class CommonSubexpressionEliminator {
  private ArrayList<func> functions;

  public CommonSubexpressionEliminator(ArrayList<func> functions) {
    this.functions = functions;
  }

  public void CS_Elimination() {
    for (func functions : functions) {
      functions.cs_elimination();
    }
  }
}
