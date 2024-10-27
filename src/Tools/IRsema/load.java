package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import Tools.Entity;
import Tools.RISCVsema.command;
import Tools.RISCVsema.memory_i;
import Tools.RISCVsema.operand.immnum;
import Tools.RISCVsema.operand.phyreg;
import codegen.RegAlloca;

public class load extends statement {
  register reg;
  register addr;

  public load(register reg, register addr) {
    this.reg = reg;
    this.addr = addr;
  }
  
  @Override
  public void print(PrintStream out) {
    out.println(reg.tostring() + " = load " + reg.type + ", " + addr.type + " " + addr.tostring());
  }

  @Override
  public ArrayList<command> toAsm(RegAlloca regAlloc) {
    ArrayList<command> ret = new ArrayList<>();
    phyreg r0 = regAlloc.GetPhyReg(regAlloc.GetVirtReg(reg), 0), r1 = regAlloc.GetPhyReg(regAlloc.GetVirtReg(addr), 1);
    ret.addAll(regAlloc.LoadToPhyReg(r1, addr));
    ret.add(new memory_i(r0, r1, new immnum(0), memory_i.Opcode.LW));
    ret.addAll(regAlloc.StorePhyReg(r0, regAlloc.GetVirtReg(reg)));
    return ret;
  }

  @Override
  public void rename(HashMap<register, Entity> renameMap) {
    if (renameMap.containsKey(addr)) {
      addr = (register) renameMap.get(addr);
    }
    return;
  }

  @Override
  public void initialize() {
    if (!addr.isGlobal) {
      liveVarIn.add(addr);
    }
    if (!reg.isGlobal) {
      liveVarIn.add(reg);
    }
  }
}
