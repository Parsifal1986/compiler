package Tools.IRsema;

import Tools.Entity;

public class constant32 extends Entity {
  public int value;

  public constant32(int value) {
    super("i32");
    this.value = value;
    this.isConst = true;
  }

  @Override
  public String tostring() {
    return Integer.toString(value);
  }
}
