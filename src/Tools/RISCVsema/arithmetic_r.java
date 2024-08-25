package Tools.RISCVsema;

import Tools.RISCVsema.operand.phyreg;

public class arithmetic_r extends command {
  phyreg rd;
  phyreg rs1;
  phyreg rs2;
  Opcode opcode;

  public arithmetic_r(phyreg rd, phyreg rs1, phyreg rs2, Opcode opcode) {
    super(null);
    this.rd = rd;
    this.rs1 = rs1;
    this.rs2 = rs2;
    this.opcode = opcode;
  }

  public arithmetic_r(phyreg rd, phyreg rs1, phyreg rs2, Opcode opcode, String label) {
    super(label);
    this.rd = rd;
    this.rs1 = rs1;
    this.rs2 = rs2;
    this.opcode = opcode;
  }

  public String toString() {
    return opcode + " " + rd + ", " + rs1 + ", " + rs2;
  }

  public enum Opcode {
    add, sub, sll, slt, sltu, xor, srl, sra, or, and, rem, div, mul;

    public String toString() {
      switch (this) {
        case add:
          return "add";
        case sub:
          return "sub";
        case sll:
          return "sll";
        case slt:
          return "slt";
        case sltu:
          return "sltu";
        case xor:
          return "xor";
        case srl:
          return "srl";
        case sra:
          return "sra";
        case or:
          return "or";
        case and:
          return "and";
        case rem:
          return "rem";
        case div:
          return "div";
        case mul:
          return "mul";
        default:
          return null;
      }
    }
  }
}
