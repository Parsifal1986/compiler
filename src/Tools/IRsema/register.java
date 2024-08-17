package Tools.IRsema;

import Tools.Entity;
import Tools.Type;

public class register extends Entity {
  public String name;

  static int varcounter = 0;
  static int avarcounter = 0;

  public register(String type) {
    super(type);
    name = "tmp.var" + avarcounter++;
  }

  public register(Type type, String name) {
    super(type.ToIrType());
    if (name == null)
      this.name = "tmp.var" + avarcounter++;
    else {
      this.name = name + varcounter++;
    }
  }

  @Override
  public String tostring() {
    return "%" + name;
  }

  public String tostring(boolean flag) {
    return "@" + name;
  }
}
