package Tools.IRsema;

import java.util.ArrayList;

import Tools.Entity;

public class ret extends control {
  Entity retVal;

  public ret(Entity retVal) {
    this.retVal = retVal;
  }

  @Override
  public ArrayList<block> next() {
    return null;
  }

  @Override
  public void print() {
    
  }
}
