package codegen;

import java.util.ArrayList;

import Tools.IRsema.func;

public class RegAllocator {
  private ArrayList<func> functons;
  
  public RegAllocator(ArrayList<func> functons) {
    this.functons = functons;
  }

  public void Alloc() {
    for (func functons : functons) {
      functons.analyze();
    }
  }
}
