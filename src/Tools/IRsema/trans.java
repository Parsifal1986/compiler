package Tools.IRsema;

import java.io.PrintStream;

import Tools.Entity;

public class trans extends statement {
  public register dst;
  public Entity src;

  public trans(register dst, Entity src) {
    this.dst = dst;
    this.src = src;
  }
  
  @Override
  public void print(PrintStream out) {
    out.println(dst.tostring() + " = " + "trunc " + src.type + " " + src.tostring() + " to " + dst.type);
  }
}
