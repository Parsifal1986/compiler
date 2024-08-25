package Tools.RISCVsema;

import Tools.RISCVsema.operand.phyreg;

import Tools.RISCVsema.operand.imm;

public class load_u extends command {
  phyreg rd;
  imm imm;
  Opcode opcode;

  public load_u(phyreg rd, imm imm, Opcode opcode) {
    super(null);
    this.rd = rd;
    this.imm = imm;
    this.opcode = opcode;
  }

  public load_u(phyreg rd, imm imm, Opcode opcode, String label) {
    super(label);
    this.rd = rd;
    this.imm = imm;
    this.opcode = opcode;
  }
  
  @Override
  public String toString() {
    return opcode + " " + rd + ", " + imm;
  }

  public enum Opcode {
    lui, auipc;

    @Override
    public String toString() {
      switch (this) {
        case lui:
          return "lui";
        case auipc:
          return "auipc";
        default:
          return null;
      }
    }
  }
}
