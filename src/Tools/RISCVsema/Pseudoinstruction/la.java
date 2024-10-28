package Tools.RISCVsema.Pseudoinstruction;

import Tools.RISCVsema.command;
import Tools.RISCVsema.operand.phyreg;

public class la extends command{
  phyreg rd;
  public String varName;

  public la(phyreg rd, String varName) {
    super(null);
    this.rd = rd;
    this.varName = varName;
  }

  @Override
  public String toString() {
    return "la " + rd + ", " + varName;
  }
}
