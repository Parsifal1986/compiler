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
  public class virtualPhyReg {
    public int regId;
    public register virtualReg;
    
    public virtualPhyReg(int regId, register virtualReg) {
      this.regId = regId;
      this.virtualReg = virtualReg;
    }
  }

  HashMap<register, virtreg> regmap;
  HashMap<String, phyreg> phyregmap;
  HashMap<Integer, phyreg> numtoregmap;
  public static ArrayList<Integer> allocableRegList;
  public ArrayList<virtualPhyReg> callerSaveRegList;
  public HashMap<Integer, register> callerSaveRegMap;
  public ArrayList<virtualPhyReg> calleeSaveRegList;
  public register raSaveRegister;
  int stacksize = 0;

  static {
    allocableRegList = new ArrayList<>();
    for (int i = 7; i < 32; i++) {
      if (i == 10 || i == 8) {
        continue;
      }
      allocableRegList.add(i);
    }
  }
  
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
    numtoregmap = new HashMap<>();
    numtoregmap.put(0, phyregmap.get("zero"));
    numtoregmap.put(1, phyregmap.get("ra"));
    numtoregmap.put(2, phyregmap.get("sp"));
    numtoregmap.put(3, phyregmap.get("gp"));
    numtoregmap.put(4, phyregmap.get("tp"));
    numtoregmap.put(5, phyregmap.get("t0"));
    numtoregmap.put(6, phyregmap.get("t1"));
    numtoregmap.put(7, phyregmap.get("t2"));
    numtoregmap.put(8, phyregmap.get("s0"));
    numtoregmap.put(9, phyregmap.get("s1"));
    numtoregmap.put(10, phyregmap.get("a0"));
    numtoregmap.put(11, phyregmap.get("a1"));
    numtoregmap.put(12, phyregmap.get("a2"));
    numtoregmap.put(13, phyregmap.get("a3"));
    numtoregmap.put(14, phyregmap.get("a4"));
    numtoregmap.put(15, phyregmap.get("a5"));
    numtoregmap.put(16, phyregmap.get("a6"));
    numtoregmap.put(17, phyregmap.get("a7"));
    numtoregmap.put(18, phyregmap.get("s2"));
    numtoregmap.put(19, phyregmap.get("s3"));
    numtoregmap.put(20, phyregmap.get("s4"));
    numtoregmap.put(21, phyregmap.get("s5"));
    numtoregmap.put(22, phyregmap.get("s6"));
    numtoregmap.put(23, phyregmap.get("s7"));
    numtoregmap.put(24, phyregmap.get("s8"));
    numtoregmap.put(25, phyregmap.get("s9"));
    numtoregmap.put(26, phyregmap.get("s10"));
    numtoregmap.put(27, phyregmap.get("s11"));
    numtoregmap.put(28, phyregmap.get("t3"));
    numtoregmap.put(29, phyregmap.get("t4"));
    numtoregmap.put(30, phyregmap.get("t5"));
    numtoregmap.put(31, phyregmap.get("t6"));
    calleeSaveRegList = new ArrayList<>();
    callerSaveRegList = new ArrayList<>();
    callerSaveRegMap = new HashMap<>();
    raSaveRegister = new register("i32");
    calleeSaveRegList.add(new virtualPhyReg(9, new register("i32")));
    for (int i = 18; i < 28; i++) {
      calleeSaveRegList.add(new virtualPhyReg(i, new register("i32")));
    }
    register tmp = new register("i32");
    callerSaveRegList.add(new virtualPhyReg(7, tmp));
    callerSaveRegMap.put(7, tmp);
    for (int i = 11; i < 18; i++) {
      tmp = new register("i32");
      callerSaveRegList.add(new virtualPhyReg(i, tmp));
      callerSaveRegMap.put(i, tmp);
    }
    for (int i = 28; i < 32; i++) {
      tmp = new register("i32");
      callerSaveRegList.add(new virtualPhyReg(i, tmp));
      callerSaveRegMap.put(i, tmp);
    }
  }

  public phyreg GetPhyReg(String rd) {
    return phyregmap.get(rd);
  }

  public phyreg GetPhyReg(int rd) {
    return numtoregmap.get(rd);
  }

  public phyreg GetPhyReg(virtreg rd) {
    if (rd.regId == -1) {
      return phyregmap.get("t0");
    } else {
      return numtoregmap.get(rd.regId);
    }
  }

  public phyreg GetPhyReg(virtreg rd, int pos) {
    if (rd.regId == -1) {
      return phyregmap.get("t" + pos);
    } else {
      return numtoregmap.get(rd.regId);
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
        ret.add(new li(GetPhyReg("t1"), new immnum(rs.stackpos)));
        ret.add(new arithmetic_r(GetPhyReg("t1"), GetPhyReg("t1"), GetPhyReg("sp"), arithmetic_r.Opcode.add));
        ret.add(new memory_i(rd, GetPhyReg("t1"), new immnum(0), memory_i.Opcode.LW));
      } else {
        ret.add(new memory_i(rd, rs.phyreg, new immnum(rs.stackpos), memory_i.Opcode.LW));
      }
    } else if (!rd.equals(GetPhyReg(rs.regId))) {
      ret.add(new mv(rd, GetPhyReg(rs.regId)));
    }
    return ret;
  }

  public ArrayList<command> StorePhyReg(phyreg reg, virtreg vr) {
    ArrayList<command> ret = new ArrayList<>();
    if (vr.isGlobal) {
      phyreg t1 = GetPhyReg("t1");
      ret.add(new load_u(t1, new immtag(vr.globalname, immtag.range.HIGH), load_u.Opcode.lui));
      ret.add(new memory_s(t1, reg, new immtag(vr.globalname, immtag.range.LOW), memory_s.Opcode.SW));
    } else if (vr.regId == -1) {
      if (vr.stackpos > 2047 || vr.stackpos < -2048) {
        ret.add(new li(GetPhyReg("t1"), new immnum(vr.stackpos)));
        ret.add(new arithmetic_r(GetPhyReg("t1"), GetPhyReg("t1"), GetPhyReg("sp"), arithmetic_r.Opcode.add));
        ret.add(new memory_s(GetPhyReg("t1"), reg, new immnum(0), memory_s.Opcode.SW));
      } else {
        ret.add(new memory_s(vr.phyreg, reg, new immnum(vr.stackpos), memory_s.Opcode.SW));
      }
    } else {
      if (!reg.equals(GetPhyReg(vr.regId))) {
        ret.add(new mv(GetPhyReg(vr.regId), reg));
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
        ret.add(new li(GetPhyReg("t1"), new immnum(vr.stackpos)));
        ret.add(new arithmetic_r(reg, GetPhyReg("t1"), GetPhyReg("sp"), arithmetic_r.Opcode.add));
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
