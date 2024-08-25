package Tools.RISCVsema;

import Tools.RISCVsema.operand.phyreg;

public class control_b extends command{
  phyreg rs1, rs2;
  String label;
  Opcode opcode;

  public control_b(phyreg rs1, phyreg rs2, String label, Opcode opcode) {
    super(null);
    this.rs1 = rs1;
    this.rs2 = rs2;
    this.label = label;
    this.opcode = opcode;
  }

  public control_b(phyreg rs1, phyreg rs2, String label, Opcode opcode, String label1) {
    super(label1);
    this.rs1 = rs1;
    this.rs2 = rs2;
    this.label = label;
    this.opcode = opcode;
  }

  @Override
  public String toString() {
    return opcode + " " + rs1 + ", " + rs2 + ", " + "." + label;
  }

  public enum Opcode {
    BEQ, BNE, BLT, BGE, BLTU, BGEU;

    @Override
    public String toString() {
      switch (this) {
        case BEQ:
          return "beq";
        case BNE:
          return "bne";
        case BLT:
          return "blt";
        case BGE:
          return "bge";
        case BLTU:
          return "bltu";
        case BGEU:
          return "bgeu";
        default:
          return null;
      }
    }
  }
}
