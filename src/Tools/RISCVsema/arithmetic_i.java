package Tools.RISCVsema;

import Tools.RISCVsema.operand.imm;
import Tools.RISCVsema.operand.phyreg;

public class arithmetic_i extends command {
  phyreg rd;
  phyreg rs1;
  public imm imm;
  Opcode opcode;

  public arithmetic_i(phyreg rd, phyreg rs1, imm imm, Opcode opcode) {
    super(null);
    this.rd = rd;
    this.rs1 = rs1;
    this.imm = imm;
    this.opcode = opcode;
  }

  public arithmetic_i(phyreg rd, phyreg rs1, imm imm, Opcode opcode, String label) {
    super(label);
    this.rd = rd;
    this.rs1 = rs1;
    this.imm = imm;
    this.opcode = opcode;
  }

  public String toString() {
    return opcode + " " + rd + ", " + rs1 + ", " + imm;
  }

  public enum Opcode {
    addi, slti, sltiu, xori, ori, andi, slli, srli, srai;
    
    public String toString() {
      switch (this) {
        case addi:
          return "addi";
        case slti:
          return "slti";
        case sltiu:
          return "sltiu";
        case xori:
          return "xori";
        case ori:
          return "ori";
        case andi:
          return "andi";
        case slli:
          return "slli";
        case srli:
          return "srli";
        case srai:
          return "srai";
        default:
          return null;
      }
    }
  }
}
