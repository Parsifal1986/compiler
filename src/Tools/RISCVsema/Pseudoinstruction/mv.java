package Tools.RISCVsema.Pseudoinstruction;

import Tools.RISCVsema.command;
import Tools.RISCVsema.operand.phyreg;

public class mv extends command {
  phyreg rd;
  phyreg rs;

  public mv(phyreg rd, phyreg rs) {
    super(null);
    this.rd = rd;
    this.rs = rs;
  }

  @Override
  public String toString() {
    return "mv " + rd + ", " + rs;
  }
}
