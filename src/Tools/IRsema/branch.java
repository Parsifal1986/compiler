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
import Tools.RISCVsema.operand.virtreg;
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
  public ArrayList<command> toasm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    phyreg x0 = regAlloc.GetPhyReg("zero");
    phyreg r0;
    if (condition != null) {
      if (condition instanceof register) {
        virtreg conditionv = regAlloc.GetVirtReg((register) condition);
        r0 = regAlloc.GetPhyReg(conditionv);
        ret.addAll(regAlloc.LoadToPhyReg(r0, condition));
        String falseBranchName = "branch_false" + branchCount++;
        ret.add(new control_b(r0, x0, falseBranchName, control_b.Opcode.BEQ));
        ret.add(new control_i(x0, trueBlock.name));
        ret.add(new control_i(x0, falseBlock.name, falseBranchName));
      } else {
        if (condition instanceof constant1) {
          if (((constant1)condition).value) {
            ret.add(new control_i(x0, trueBlock.name));
          } else {
            ret.add(new control_i(x0, falseBlock.name));
          }
        } else {
          if (((constant32) condition).value != 0) {
            ret.add(new control_i(x0, trueBlock.name));
          } else {
            ret.add(new control_i(x0, falseBlock.name));
          }
        }
      }
    } else {
      ret.add(new control_i(x0, trueBlock.name));
    }
    return ret;
  }

  @Override
  public Pair<Boolean, statement> propagate() {
    if (condition != null && condition.isConst) {
      if (condition instanceof register) {
        if (((register)condition).isConst) {
          condition = ((register) condition).value;
        }
      }
      if (condition instanceof constant1) {
        if (((constant1) condition).value) {
          this.condition = null;
        } else {
          this.condition = null;
          this.trueBlock = falseBlock;
        }
      } else if (condition instanceof constant32) {
        if (((constant32) condition).value != 0) {
          this.condition = null;
        } else {
          this.condition = null;
          this.trueBlock = falseBlock;
        }
      }
      return new Pair<Boolean, statement>(true, this);
    } else {
      return new Pair<Boolean, statement>(false, this);
    }
  }

  @Override
  public void rename(HashMap<register, Entity> renameMap) {
    if (condition instanceof register) {
      if (renameMap.containsKey((register)condition)) {
        condition = renameMap.get(condition);
      }
    }
  }
  
  @Override
  public void initialize() {
    if (condition instanceof register) {
      if (!((register) condition).isGlobal) {
        liveVarIn.add((register) condition);
      }
    }
  }
}