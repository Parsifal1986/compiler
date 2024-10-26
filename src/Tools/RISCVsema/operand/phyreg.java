package Tools.RISCVsema.operand;

public class phyreg extends reg {
  String name;
  public int num;
  public phyreg(String name, int num) {
    this.name = name;
    this.num = num;
  }

  @Override
  public String toString() {
    return name;
  }
  
  public boolean equals(phyreg reg) {
    return num == reg.num;
  }
}
