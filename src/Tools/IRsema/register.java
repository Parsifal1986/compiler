package Tools.IRsema;

import Tools.Entity;
import Tools.Type;

public class register extends Entity {
  public String name;
  public boolean isGlobal = false;

  static int varcounter = 0;
  static int avarcounter = 0;

  public register(String type) {
    super(type);
    name = "tmp.var" + avarcounter++;
    this.isGlobal = false;
  }

  public register(Type type, String name, boolean isGlobal) {
    super(type.ToIrType());
    if (name == null)
      this.name = "tmp.var" + avarcounter++;
    else {
      this.name = name + varcounter++;
    }
    this.isGlobal = isGlobal;
  }

  public register(String type, String name, boolean isGlobal) {
    super(type);
    if (name == null)
      this.name = "tmp.var" + avarcounter++;
    else {
      this.name = name + varcounter++;
    }
    this.isGlobal = isGlobal;
  }

  public register(Type type) {
    super(type.ToIrType());
    name = "tmp.var" + avarcounter++;
    this.isGlobal = false;
  }

  @Override
  public String tostring() {
    return (isGlobal ? "@" : "%") + name;
  }
}
