package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import Tools.Entity;
import Tools.RISCVsema.command;
import Tools.RISCVsema.control_b;
import Tools.RISCVsema.control_i;
import Tools.RISCVsema.operand.phyreg;
import codegen.RegAlloca;

public class branch extends control {
  public Entity condition;
  public block trueBlock;
  public block falseBlock;

  static int branchCount = 0;

  public branch(Entity condition, block trueBlock, block falseBlock) {
    this.condition = condition;
    this.trueBlock = trueBlock;
    this.falseBlock = falseBlock;
  }

  @Override
  public ArrayList<block> next() {
    if (condition == null) {
      return new ArrayList<block>(Arrays.asList(trueBlock));
    } else {
      return new ArrayList<block>(Arrays.asList(trueBlock, falseBlock));
    }
  }

  @Override
  public void print(PrintStream out) {
    out.println("br " + (condition == null ? "label %" + trueBlock.name : "i1 " + condition.tostring() + ", label %" + trueBlock.name
        + ", label %" + falseBlock.name));
  }

  @Override
  public ArrayList<command> toAsm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    phyreg x0 = regAlloc.GetPhyReg("zero");
    if (condition != null) {
      phyreg r0 = regAlloc.GetPhyReg("t0");
      ret.addAll(regAlloc.LoadToPhyReg(r0, condition));
      String falseBranchName = "branch_false" + branchCount++;
      ret.add(new control_b(r0, x0, falseBranchName, control_b.Opcode.BEQ));
      ret.add(new control_i(x0, trueBlock.name));
      ret.add(new control_i(x0, falseBlock.name, falseBranchName));
    } else {
      ret.add(new control_i(x0, trueBlock.name));
    }
    return ret;
  }
}