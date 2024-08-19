package Tools.IRsema;

import java.io.PrintStream;
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
  public void print(PrintStream out) {
    if (res != null && retType != "void") {
      out.print(res.tostring() + " = call " + retType + " @" + funcname + "(");
    } else {
      out.print("call " + retType + " " + "@" + funcname + "(");
    }
    for (int i = 0; i < args.size(); i++) {
      out.print(args.get(i).type + " " + args.get(i).tostring());
      if (i != args.size() - 1) {
        out.print(", ");
      }
    }
    out.println(")");
  }
  
}
