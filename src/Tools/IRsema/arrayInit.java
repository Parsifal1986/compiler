package Tools.IRsema;

import Tools.Entity;

public class arrayInit extends Entity {
  int size;
  String type;
  String initialize;

  public arrayInit(int size, String type, String initialize) {
    super("ptr");
    this.size = size;
    this.type = type;
    this.initialize = initialize;
  }
  
}
