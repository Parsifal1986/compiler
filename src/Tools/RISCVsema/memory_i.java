package Tools.RISCVsema;

import Tools.RISCVsema.operand.imm;
import Tools.RISCVsema.operand.phyreg;

public class memory_i extends command {
  phyreg rd, rs1;
  imm imm;
  Opcode opcode;

  public memory_i(phyreg rd, phyreg rs1, imm imm, Opcode opcode) {
    super(null);
    this.rd = rd;
    this.rs1 = rs1;
    this.imm = imm;
    this.opcode = opcode;
  }

  public memory_i(phyreg rd, phyreg rs1, imm imm, Opcode opcode, String label) {
    super(label);
    this.rd = rd;
    this.rs1 = rs1;
    this.imm = imm;
    this.opcode = opcode;
  }

  @Override
  public String toString() {
    return opcode + " " + rd + ", " + imm + "(" + rs1 + ")";
  }

  public enum Opcode {
    LW, LH, LHU, LB, LBU;

    public String toString() {
      switch (this) {
        case LW:
          return "lw";
        case LH:
          return "lh";
        case LHU:
          return "lhu";
        case LB:
          return "lb";
        case LBU:
          return "lbu";
        default:
          return null;
      }
    }
  }
}
