package Tools.RISCVsema;

import Tools.RISCVsema.operand.phyreg;

public class control_r extends command {
  phyreg rd;
  phyreg rs1;
  String label;

  public control_r(phyreg rd, phyreg rs1, String label) {
    super(null);
    this.rd = rd;
    this.rs1 = rs1;
    this.label = label;
  }

  public control_r(phyreg rd, phyreg rs1, String label, String commandLabel) {
    super(commandLabel);
    this.rd = rd;
    this.rs1 = rs1;
    this.label = label;
  }

  @Override
  public String toString() {
    return "jalr " + rd + rs1 + "." + label;
  }
}
