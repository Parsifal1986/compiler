package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;

import Tools.Entity;

public class ret extends control {
  Entity retVal;

  public ret(Entity retVal) {
    this.retVal = retVal;
  }

  @Override
  public ArrayList<block> next() {
    return new ArrayList<block>();
  }

  @Override
  public void print(PrintStream out) {
    out.println("ret " + retVal.type + " " + retVal.tostring());
  }
}
