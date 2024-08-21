package Tools.IRsema;

import Tools.Entity;

public class nullptr extends Entity {
  public nullptr() {
    super("ptr");
  }

  @Override
  public String tostring() {
    return "null";
  }
}
