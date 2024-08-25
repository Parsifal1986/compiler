package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import Tools.RISCVsema.arithmetic_r;
import Tools.RISCVsema.command;
import Tools.RISCVsema.Pseudoinstruction.li;
import Tools.RISCVsema.Pseudoinstruction.mv;
import Tools.RISCVsema.Pseudoinstruction.ret;
import Tools.RISCVsema.operand.immnum;
import Tools.RISCVsema.operand.virtreg;
import Tools.RISCVsema.section.asmsection;
import Tools.RISCVsema.section.textsection;
import codegen.RegAlloca;
import Tools.RISCVsema.control_i;

public class func {
  public String name;
  public String type;
  public ArrayList<register> args;
  public ArrayList<EntryPair> entry;
  public block headblock;

  public static class EntryPair {
    public register reg;
    public String type;

    public EntryPair(register reg, String type) {
      this.reg = reg;
      this.type = type;
    }
  }

  public func() {
    entry = new ArrayList<>();
    args = new ArrayList<register>();
  }

  public void visit(PrintStream out) {
    out.print("define " + type + " @" + name + "(");
    for (int i = 0; i < args.size(); i++) {
      out.print(args.get(i).type + args.get(i).tostring());
      if (i < args.size() - 1) {
        out.print(", ");
      }
    }
    out.println(") {");
    if (entry.size() > 0) {
      out.println("entry:");
      entry.forEach(
        e -> out.println("\t" + e.reg.tostring() + " = alloca " + e.type)
      );
      out.print("\t");
      (new branch(null, headblock, null)).print(out);
    }
    Queue<block> q = new LinkedList<block>();
    q.add(headblock);
    while (q.size() > 0) {
      block current = q.poll();
      if (current.isprint) {
        continue;
      }
      current.isprint = true;
      out.println(current.name + ":");
      if (current.statements.size() > 0) {
        for (statement s : current.statements) {
          out.print("\t");
          s.print(out);
        }
      }
      if (current.next != null) {
        out.print("\t");
        current.next.print(out);
        current.next.next().forEach(q::add);  
      } else {
        if (name.equals("main")) {
          out.println("\tret i32 0");
        } else {
          out.println("\tret void");
        }
      }
    }
    out.println("}");
  }

  public asmsection trans() {
    textsection text = new textsection(name, true);
    RegAlloca regAlloca = new RegAlloca();
    text.add(new mv(regAlloca.GetPhyReg("s0"), regAlloca.GetPhyReg("sp")));
    text.add(new li(regAlloca.GetPhyReg("t0"), null));
    text.add(new arithmetic_r(regAlloca.GetPhyReg("sp"), regAlloca.GetPhyReg("sp"), regAlloca.GetPhyReg("t0"), arithmetic_r.Opcode.add));
    if (args.size() <= 8) {
      for (int i = 0; i < args.size(); i++) {
        virtreg tmp = regAlloca.GetVirtReg(args.get(i));
        text.addAll(regAlloca.StorePhyReg(regAlloca.GetPhyReg("a" + i), tmp));
      }
    } else {
      for (int i = 0; i < 8; i++) {
        virtreg tmp = regAlloca.GetVirtReg(args.get(i));
        text.addAll(regAlloca.StorePhyReg(regAlloca.GetPhyReg("a" + i), tmp));
      }
      for (int i = 8; i < args.size(); i++) {
        virtreg tmp = regAlloca.GetVirtReg(regAlloca.GetPhyReg("s0"), (i - args.size()) * 4, new register("i32"));
        text.addAll(regAlloca.LoadToPhyReg(regAlloca.GetPhyReg("t0"), tmp));
        text.addAll(regAlloca.StorePhyReg(regAlloca.GetPhyReg("t0"), regAlloca.GetVirtReg(args.get(i))));
      }
    }
    if (entry.size() > 0) {
      for (EntryPair entry : entry) {
        text.addAll((new alloca(entry.reg, entry.type)).toAsm(regAlloca));
      }
      text.add(new control_i(regAlloca.GetPhyReg("zero"), headblock.name));
    }
    Queue<block> q = new LinkedList<block>();
    q.add(headblock);
    while (q.size() > 0) {
      block current = q.poll();
      if (current.istrans) {
        continue;
      }
      current.istrans = true;
      ArrayList<command> tmp = new ArrayList<>();
      if (current.statements.size() > 0) {
        for (int i = 0; i < current.statements.size(); i++) {
          tmp.addAll(current.statements.get(i).toAsm(regAlloca));
        }
      }
      if (current.next != null) {
        tmp.addAll(current.next.toAsm(regAlloca));
        current.next.next().forEach(q::add);
      } else {
        if (name.equals("main")) {
          tmp.add(new li(regAlloca.GetPhyReg("a0"), new immnum(0)));
          tmp.add(new ret());
        } else {
          tmp.add(new ret());
        }
      }
      tmp.get(0).label = current.name;
      text.addAll(tmp);
    }
    int stacksize = (int)Math.ceil(1.0 * regAlloca.getTotalSpace() / 16) * 16;
    ((li)text.commands.get(1)).imm = new immnum(0 - stacksize);
    text.stacksize = stacksize;
    return text;
  }

  public void cleanPhi() {
    HashMap<String, block> labelMap = new HashMap<>();
    Queue<block> q = new LinkedList<block>();
    ArrayList<phi> phiList = new ArrayList<>();
    labelMap.put(headblock.name, headblock);
    q.add(headblock);
    while (q.size() > 0) {
      block current = q.poll();
      labelMap.put(current.name, current);
      if (current.isclean) {
        continue;
      }
      current.isclean = true;
      if (current.statements.size() > 0) {
        Iterator<statement> it = current.statements.iterator();
        while(it.hasNext()) {
          statement s = it.next();
          if (s instanceof phi) {
            phi p = (phi)s;
            phiList.add(p);
            it.remove();
          }
        }
      }
      if (current.next != null) {
        current.next.next().forEach(q::add);
      }
    }
    for (phi p : phiList) {
      block b1 = labelMap.get(p.label1);
      block b2 = labelMap.get(p.label2);
      b1.add(new let(p.dst, p.src1));
      b2.add(new let(p.dst, p.src2));
    }
  }
}
