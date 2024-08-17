package Tools.IRsema;

import Tools.Entity;

public class constant8 extends Entity {
  public boolean value;

  public constant8(boolean value) {
    super("i8");
    this.value = value;
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
