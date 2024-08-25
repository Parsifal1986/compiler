package Tools.RISCVsema;

import Tools.RISCVsema.operand.phyreg;

public class control_i extends command {
  phyreg rd;
  String label;

  public control_i(phyreg rd, String label) {
    super(null);
    this.rd = rd;
    this.label = label;
  }

  public control_i(phyreg rd, String label, String commandLabel) {
    super(commandLabel);
    this.rd = rd;
    this.label = label;
  }

  @Override
  public String toString() {
    return "jal " + rd + ", " + "." + label;
  }
}
