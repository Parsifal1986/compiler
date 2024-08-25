package Tools.RISCVsema.operand;

public class phyreg extends reg {
  String name;
  int num;
  public phyreg(String name, int num) {
    this.name = name;
    this.num = num;
  }

  @Override
  public String toString() {
    return name;
  }
}
