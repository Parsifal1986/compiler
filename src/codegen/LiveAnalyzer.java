package codegen;

import java.util.ArrayList;

import Tools.IRsema.func;

public class LiveAnalyzer {
  private ArrayList<func> functons;
  
  public LiveAnalyzer(ArrayList<func> functons) {
    this.functons = functons;
  }

  public void trans() {
    for (func functons : functons) {
      functons.analyze();
    }
  }
}
