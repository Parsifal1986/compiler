package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Tools.Pair;

import Tools.Entity;
import Tools.RISCVsema.command;
import Tools.RISCVsema.control_b;
import Tools.RISCVsema.control_i;
import Tools.RISCVsema.operand.phyreg;
import codegen.RegAlloca;

public class asmbranch extends control {
  public Entity rs1, rs2;
  public block trueBlock;
  public block falseBlock;
  public Opcode op;

  static int branchCount = 0;

  public asmbranch(Entity rs1, Entity rs2, block trueBlock, block falseBlock, Opcode op) {
    this.rs1 = rs1;
    this.rs2 = rs2;
    this.trueBlock = trueBlock;
    this.falseBlock = falseBlock;
    this.op = op;
  }

  public enum Opcode {
    BEQ, BNE, BLT, BGE, BLE, BGT, BLTU, BGEU;
  }

  @Override
  public ArrayList<block> next() {
    return new ArrayList<block>(Arrays.asList(trueBlock, falseBlock));
  }

  @Override
  public void print(PrintStream out) {

  }

  @Override
  public ArrayList<command> toasm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    phyreg x0 = regAlloc.GetPhyReg("zero");
    phyreg r0 = regAlloc.GetPhyReg(rs1, 0), r1 = regAlloc.GetPhyReg(rs2, 1);
    ret.addAll(regAlloc.LoadToPhyReg(r0, rs1));
    ret.addAll(regAlloc.LoadToPhyReg(r1, rs2));
    String TrueBranchName = "branch_true" + branchCount++;
    control_b.Opcode opcode;
    switch (op) {
      case BEQ:
        opcode = control_b.Opcode.BEQ;
        break;
      case BNE:
        opcode = control_b.Opcode.BNE;
        break;
      case BLT:
        opcode = control_b.Opcode.BLT;
        break;
      case BGE:
        opcode = control_b.Opcode.BGE;
        break;
      case BLE:
        opcode = control_b.Opcode.BLE;
        break;
      case BGT:
        opcode = control_b.Opcode.BGT;
        break;
      case BLTU:
        opcode = control_b.Opcode.BLTU;
        break;
      case BGEU:
        opcode = control_b.Opcode.BGEU;
        break;
      default:
        opcode = control_b.Opcode.BEQ;
        break;
    }
    ret.add(new control_b(r0, r1, TrueBranchName, opcode));
    ret.add(new control_i(x0, falseBlock.name));
    ret.add(new control_i(x0, trueBlock.name, TrueBranchName));
    return ret;
  }

  @Override
  public void rename(HashMap<register, Entity> renameMap) {
  }

  @Override
  public Pair<Boolean, statement> propagate() {
    return new Pair<Boolean, statement> (false, this);
  }
  
  @Override
  public void initialize() {
    if (rs1 instanceof register) {
      if (!((register) rs1).isGlobal) {
        liveVarIn.add((register) rs1);
      }
    }
    if (rs2 instanceof register) {
      if (!((register) rs2).isGlobal) {
        liveVarIn.add((register) rs2);
      }
    }
  }
}
