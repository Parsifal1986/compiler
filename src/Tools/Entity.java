package Tools;

abstract public class Entity {
  public String type;
  public boolean isConst;

  public Entity(String type) {
    this.type = type;
  }

  abstract public String tostring();

  public int size() {
    if (type == "i32") {
      return 4;
    } else if (type == "i8") {
      return 1;
    } else {
      return 8;
    }
  }
}
