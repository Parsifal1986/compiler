package Tools.RISCVsema;

import Tools.RISCVsema.operand.phyreg;
import Tools.RISCVsema.operand.imm;

public class memory_s extends command {
  phyreg rs1, rs2;
  imm imm;
  Opcode opcode;

  public memory_s(phyreg rs1, phyreg rs2, imm imm, Opcode opcode) {
    super(null);
    this.rs1 = rs1;
    this.rs2 = rs2;
    this.imm = imm;
    this.opcode = opcode;
  }

  public memory_s(phyreg rs1, phyreg rs2, imm imm, Opcode opcode, String label) {
    super(label);
    this.rs1 = rs1;
    this.rs2 = rs2;
    this.imm = imm;
    this.opcode = opcode;
  }

  @Override
  public String toString() {
    return opcode + " " + rs2 + ", " + imm + "(" + rs1 + ")";
  }

  public enum Opcode {
    SW, SH, SB;

    public String toString() {
      switch (this) {
        case SW:
          return "sw";
        case SH:
          return "sh";
        case SB:
          return "sb";
        default:
          return null;
      }
    }
  }
}
