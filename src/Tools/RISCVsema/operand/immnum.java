package Tools.RISCVsema.operand;

public class immnum extends imm {
  int value;

  public immnum(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "" + value;
  }
}
