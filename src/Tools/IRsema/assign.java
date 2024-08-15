package Tools.IRsema;

import Tools.Entity;

public class assign extends statement {
  public register left;
  public Entity right;

  public assign(register left, Entity right) {
    this.left = left;
    this.right = right;
  }

  public void print() {
  }
}
