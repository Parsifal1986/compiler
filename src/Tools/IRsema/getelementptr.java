package Tools.IRsema;

import java.util.ArrayList;

import Tools.Entity;

public class getelementptr extends statement {
  public String type;
  public register reg;
  public register ptr;
  public ArrayList<Entity> index;

  public getelementptr(String type, register reg, register ptr, ArrayList<Entity> index) {
    this.type = type;
    this.reg = reg;
    this.ptr = ptr;
    this.index = index;
  }
  
  @Override
  public void print() {
    
  }
}
