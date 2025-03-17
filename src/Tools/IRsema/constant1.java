package Tools.IRsema;

import Tools.Entity;

public class constant1 extends Entity {
  public boolean value;

  public constant1(boolean value) {
    super("i1");
    this.value = value;
    this.isConst = true;
  }

  @Override
  public String tostring() {
    if (value) {
      return "1";
    } else {
      return "0";
    }
  }
  
}
