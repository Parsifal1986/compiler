package codegen;

import java.util.ArrayList;

import Tools.IRsema.func;

public class Mem2Reger {
  private ArrayList<func> functions;

  public Mem2Reger(ArrayList<func> functions) {
    this.functions = functions;
  }
  
  public void ToReg() {
    for (func functions : functions) {
      functions.prep();
      functions.mem2reg();
    }
  }
}
