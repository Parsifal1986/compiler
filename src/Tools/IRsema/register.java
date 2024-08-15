package Tools.IRsema;

import Tools.Entity;
import Tools.Type;

public class register extends Entity {
  public String name;

  public register(String type) {
    super(type);
    name = null;
  }

  public register(Type type, String name) {
    super("");
    if (type.getDim() != 0) {
      this.type = "ptr";
    } else {
      if (type.getTypename() == "int") {
        this.type = "i32";
      } else if (type.getTypename() == "bool") {
        this.type = "i8";
      } else {
        this.type = "ptr";
      }
    }
    this.name = name;
  }
}
