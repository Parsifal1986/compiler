package Tools.IRsema;

public class alloca extends statement {
  public register reg;
  public String type;

  public alloca(register reg, String type) {
    this.reg = reg;
    this.type = type;
  }

  public void print() {

  }
}
