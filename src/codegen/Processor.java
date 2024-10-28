package codegen;

import java.util.ArrayList;

import Tools.IRsema.func;

public class Processor {
  private ArrayList<func> functions;

  public Processor(ArrayList<func> functions) {
    this.functions = functions;
  }
  
  public void process() {
    for (func functions : functions) {
      functions.process();
    }
  }
}
