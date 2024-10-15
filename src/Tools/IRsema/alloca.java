package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import Tools.Entity;
import Tools.RISCVsema.arithmetic_i;
import Tools.RISCVsema.arithmetic_r;
import Tools.RISCVsema.command;
import Tools.RISCVsema.memory_s;
import Tools.RISCVsema.Pseudoinstruction.li;
import Tools.RISCVsema.operand.immnum;
import Tools.RISCVsema.operand.phyreg;
import Tools.RISCVsema.operand.virtreg;
import codegen.RegAlloca;

public class alloca extends statement {
  public register reg;
  public String type;

  public alloca(register reg, String type) {
    this.reg = reg;
    this.type = type;
  }

  @Override
  public void print(PrintStream out) {
    out.println(reg.tostring() + " = alloca " + type);
  }

  @Override
  public ArrayList<command> toAsm(RegAlloca regAlloca) {
    ArrayList<command> ret = new ArrayList<>();
    virtreg space = regAlloca.GetVirtReg(new register("")), ptr = regAlloca.GetVirtReg(reg);
    phyreg sp = regAlloca.GetPhyReg("sp");
    phyreg target = regAlloca.GetPhyReg("t0");
    phyreg t3 = regAlloca.GetPhyReg("t3");
    if (space.getStackPos() > 2047 || space.getStackPos() < -2048) {
      ret.add(new li(t3, new immnum(space.getStackPos())));
      ret.add(new arithmetic_r(target, sp, t3, arithmetic_r.Opcode.add));
    } else {
      ret.add(new arithmetic_i(target, sp, new immnum(space.getStackPos()), arithmetic_i.Opcode.addi));
    }
    if (ptr.getStackPos() > 2047 || ptr.getStackPos() < -2048) {
      ret.add(new li(t3, new immnum(ptr.getStackPos())));
      ret.add(new arithmetic_r(t3, sp, t3, arithmetic_r.Opcode.add));
      ret.add(new memory_s(t3, target, new immnum(0), memory_s.Opcode.SW));
    } else {
      ret.add(new memory_s(sp, target, new immnum(ptr.getStackPos()), memory_s.Opcode.SW));
    }
    return ret;
  }

  @Override
  public void rename(HashMap<register, Entity> renameMap) {
    return;
  }

  @Override
  public void initialize() {
    liveVarIn = new HashSet<>(Arrays.asList(reg));
  }
}
