package Tools.IRsema;

import java.util.ArrayList;

import Tools.Entity;

public class call extends statement {
  public String funcname;
  public register res; 
  public String retType;
  public ArrayList<Entity> args;

  public call(String funcname, register res, String retType, ArrayList<Entity> args) {
    this.funcname = funcname;
    this.res = res;
    this.retType = retType;
    this.args = args;
  }

  @Override
  public void print() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'print'");
  }
  
}
