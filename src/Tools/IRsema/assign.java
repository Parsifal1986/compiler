package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import Tools.Pair;

import Tools.Entity;
import Tools.RISCVsema.command;
import Tools.RISCVsema.memory_s;
import Tools.RISCVsema.operand.immnum;
import Tools.RISCVsema.operand.phyreg;
import codegen.RegAlloca;

public class assign extends statement {
  public register left;
  public Entity right;

  public assign(register left, Entity right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public void print(PrintStream out) {
    out.println("store " + right.type + " " + right.tostring() + ", " + left.type + " "+ left.tostring());
  }

  @Override
  public ArrayList<command> toasm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    phyreg data = regAlloc.GetPhyReg(right, 1);
    phyreg addr = regAlloc.GetPhyReg(left, 0);
    ret.addAll(regAlloc.LoadToPhyReg(addr, left));
    ret.addAll(regAlloc.LoadToPhyReg(data, right));
    ret.add(new memory_s(addr, data, new immnum(0), memory_s.Opcode.SW));
    return ret;
  }

  @Override
  public void rename(HashMap<register, Entity> renameMap) {
    if (right instanceof register && renameMap.containsKey(right)) {
      right = renameMap.get(right);
    }
    return;
  }

  @Override
  public Pair<Boolean, statement> propagate() {
    if (right instanceof register) {
      if (((register) right).isConst) {
        right = ((register) right).value;
      }
    }
    return new Pair<Boolean, statement> (false, this);
  }

  @Override
  public void initialize() {
    if (right instanceof register) {
      register r = (register) right;
      if (!r.isGlobal) {
        liveVarIn.add((register) right);
      }
    }
    if (!left.isGlobal) {
      liveVarIn.add(left);
    }
  }
}
