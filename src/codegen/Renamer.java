package codegen;

import java.util.ArrayList;

import Tools.IRsema.func;

public class Renamer {
  private ArrayList<func> functions;

  public Renamer(ArrayList<func> functions) {
    this.functions = functions;
  }
  
  public void Rename() {
    for (func functions : functions) {
      functions.rename();
    }
  }
}
