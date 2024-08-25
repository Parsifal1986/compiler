package Tools.RISCVsema.Pseudoinstruction;

import Tools.RISCVsema.command;
import Tools.RISCVsema.operand.imm;
import Tools.RISCVsema.operand.phyreg;

public class li extends command{
  phyreg rd;
  public imm imm;

  public li(phyreg rd, imm imm) {
    super(null);
    this.rd = rd;
    this.imm = imm;
  }

  public li(phyreg rd, imm imm, String label) {
    super(label);
    this.rd = rd;
    this.imm = imm;
  }

  @Override
  public String toString() {
    return "li " + rd + ", " + imm;
  }
}
