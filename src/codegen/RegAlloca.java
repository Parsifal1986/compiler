package codegen;

import java.util.ArrayList;
import java.util.HashMap;

import Tools.Entity;
import Tools.IRsema.constant1;
import Tools.IRsema.constant32;
import Tools.IRsema.nullptr;
import Tools.IRsema.register;
import Tools.RISCVsema.arithmetic_i;
import Tools.RISCVsema.arithmetic_r;
import Tools.RISCVsema.command;
import Tools.RISCVsema.load_u;
import Tools.RISCVsema.memory_i;
import Tools.RISCVsema.memory_s;
import Tools.RISCVsema.Pseudoinstruction.li;
import Tools.RISCVsema.Pseudoinstruction.mv;
import Tools.RISCVsema.operand.immnum;
import Tools.RISCVsema.operand.immtag;
import Tools.RISCVsema.operand.phyreg;
import Tools.RISCVsema.operand.virtreg;

public class RegAlloca {
  HashMap<register, virtreg> regmap;
  HashMap<String, phyreg> phyregmap;
  public register[] tmpRegList;
  int stacksize = 0;
  
  public RegAlloca() {
    regmap = new HashMap<>();
    phyregmap = new HashMap<>();
    phyregmap.put("zero", new phyreg("zero", 0));
    phyregmap.put("ra", new phyreg("ra", 1));
    phyregmap.put("sp", new phyreg("sp", 2));
    phyregmap.put("gp", new phyreg("gp", 3));
    phyregmap.put("tp", new phyreg("tp", 4));
    phyregmap.put("t0", new phyreg("t0", 5));
    phyregmap.put("t1", new phyreg("t1", 6));
    phyregmap.put("t2", new phyreg("t2", 7));
    phyregmap.put("s0", new phyreg("s0", 8));
    phyregmap.put("s1", new phyreg("s1", 9));
    phyregmap.put("a0", new phyreg("a0", 10));
    phyregmap.put("a1", new phyreg("a1", 11));
    phyregmap.put("a2", new phyreg("a2", 12));
    phyregmap.put("a3", new phyreg("a3", 13));
    phyregmap.put("a4", new phyreg("a4", 14));
    phyregmap.put("a5", new phyreg("a5", 15));
    phyregmap.put("a6", new phyreg("a6", 16));
    phyregmap.put("a7", new phyreg("a7", 17));
    phyregmap.put("s2", new phyreg("s2", 18));
    phyregmap.put("s3", new phyreg("s3", 19));
    phyregmap.put("s4", new phyreg("s4", 20));
    phyregmap.put("s5", new phyreg("s5", 21));
    phyregmap.put("s6", new phyreg("s6", 22));
    phyregmap.put("s7", new phyreg("s7", 23));
    phyregmap.put("s8", new phyreg("s8", 24));
    phyregmap.put("s9", new phyreg("s9", 25));
    phyregmap.put("s10", new phyreg("s10", 26));
    phyregmap.put("s11", new phyreg("s11", 27));
    phyregmap.put("t3", new phyreg("t3", 28));
    phyregmap.put("t4", new phyreg("t4", 29));
    phyregmap.put("t5", new phyreg("t5", 30));
    phyregmap.put("t6", new phyreg("t6", 31));
    tmpRegList = new register[4];
    for (int i = 0; i < 4; i++) {
      tmpRegList[i] = new register("i32");
    }
  }

  public phyreg GetPhyReg(String rd) {
    return phyregmap.get(rd);
  }

  public phyreg GetPhyReg(virtreg rd) {
    if (rd.regId == -1) {
      return phyregmap.get("t0");
    } else {
      return phyregmap.get("t" + rd.regId);
    }
  }

  public phyreg GetPhyReg(virtreg rd, int pos) {
    if (rd.regId == -1) {
      return phyregmap.get("t" + pos);
    } else {
      return phyregmap.get("t" + rd.regId);
    }
  }

  public phyreg GetPhyReg(Entity entity, int pos) {
    if (entity instanceof register) {
      return GetPhyReg(GetVirtReg((register)entity), pos);
    } else {
      return GetPhyReg("t" + pos);
    }
  }

  public ArrayList<command> LoadToPhyReg(phyreg rd, Entity rs) {
    ArrayList<command> ret = new ArrayList<>();
    if (rs instanceof register) {
      ret.addAll(LoadToPhyReg(rd, GetVirtReg((register)rs)));
    } else if (rs instanceof constant1) {
      ret.add(new li(rd, new immnum(((constant1)rs).value ? 1 : 0)));
    } else if (rs instanceof constant32) {
      ret.add(new li(rd, new immnum(((constant32)rs).value)));
    } else if (rs instanceof nullptr) {
      ret.add(new li(rd, new immnum(0)));
    }
    return ret;
  }

  public ArrayList<command> LoadToPhyReg(phyreg rd, virtreg rs) {
    ArrayList<command> ret = new ArrayList<>();
    if (rs.isGlobal) {
      ret.add(new load_u(rd, new immtag(rs.globalname, immtag.range.HIGH), load_u.Opcode.lui));
      ret.add(new memory_i(rd, rd, new immtag(rs.globalname, immtag.range.LOW), memory_i.Opcode.LW));
    } else if (rs.regId == -1) {
      if (rs.stackpos > 2047 || rs.stackpos < -2048) {
        ret.add(new li(GetPhyReg("t2"), new immnum(rs.stackpos)));
        ret.add(new arithmetic_r(GetPhyReg("t2"), GetPhyReg("t2"), GetPhyReg("sp"), arithmetic_r.Opcode.add));
        ret.add(new memory_i(rd, GetPhyReg("t2"), new immnum(0), memory_i.Opcode.LW));
      } else {
        ret.add(new memory_i(rd, rs.phyreg, new immnum(rs.stackpos), memory_i.Opcode.LW));
      }
    } else if (!rd.equals(rs.regId)) {
      ret.add(new mv(rd, GetPhyReg("t" + rs.regId)));
    }
    return ret;
  }

  public ArrayList<command> StorePhyReg(phyreg reg, virtreg vr) {
    ArrayList<command> ret = new ArrayList<>();
    if (vr.isGlobal) {
      phyreg t2 = GetPhyReg("t2");
      ret.add(new load_u(t2, new immtag(vr.globalname, immtag.range.HIGH), load_u.Opcode.lui));
      ret.add(new memory_s(t2, reg, new immtag(vr.globalname, immtag.range.LOW), memory_s.Opcode.SW));
    } else if (vr.regId == -1) {
      if (vr.stackpos > 2047 || vr.stackpos < -2048) {
        ret.add(new li(GetPhyReg("t2"), new immnum(vr.stackpos)));
        ret.add(new arithmetic_r(GetPhyReg("t2"), GetPhyReg("t2"), GetPhyReg("sp"), arithmetic_r.Opcode.add));
        ret.add(new memory_s(GetPhyReg("t2"), reg, new immnum(0), memory_s.Opcode.SW));
      } else {
        ret.add(new memory_s(vr.phyreg, reg, new immnum(vr.stackpos), memory_s.Opcode.SW));
      }
    } else {
      if (!reg.equals(vr.regId)) {
        ret.add(new mv(GetPhyReg("t" + vr.regId), reg));
      }
    }
    return ret;
  }

  public ArrayList<command> GetVirtregAddr(phyreg reg, virtreg vr) {
    ArrayList<command> ret = new ArrayList<>();
    if (vr.isGlobal) {
      ret.add(new load_u(reg, new immtag(vr.globalname, immtag.range.HIGH), load_u.Opcode.lui));
      ret.add(new arithmetic_i(reg, reg, new immtag(vr.globalname, immtag.range.LOW), arithmetic_i.Opcode.addi));
    } else {
      if (vr.stackpos > 2047 || vr.stackpos < -2048) {
        ret.add(new li(GetPhyReg("t2"), new immnum(vr.stackpos)));
        ret.add(new arithmetic_r(reg, GetPhyReg("t2"), GetPhyReg("sp"), arithmetic_r.Opcode.add));
      } else {
        ret.add(new arithmetic_i(reg, vr.phyreg, new immnum(vr.stackpos), arithmetic_i.Opcode.addi));
      }
    }
    return ret;

  }

  public virtreg GetVirtReg(register reg) {
    if (regmap.containsKey(reg)) {
      return regmap.get(reg);
    }
    if (reg.isGlobal) {
      virtreg tmpreg = new virtreg(reg.name);
      regmap.put(reg, tmpreg);
      return tmpreg;
    } else if (reg.regId == -1) {
      int tmp = stacksize;
      stacksize += 4;
      virtreg tmpreg = new virtreg(tmp, GetPhyReg("sp"));
      regmap.put(reg, tmpreg);
      return tmpreg;
    } else {
      virtreg tmpreg = new virtreg(reg.regId);
      regmap.put(reg, tmpreg);
      return tmpreg;
    }
  }

  public virtreg GetVirtReg(phyreg reletive, int pos, register reg) {
    virtreg tmpreg = new virtreg(pos, reletive);
    if (reg != null) {
      regmap.put(reg, tmpreg);
    }
    return tmpreg;
  }

  public int getTotalSpace() {
    return stacksize;
  }

}
