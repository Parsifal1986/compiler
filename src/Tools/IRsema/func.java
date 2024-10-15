package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import Tools.Entity;
import Tools.Interval;
import Tools.domtree;
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
  HashMap<register, AllocaCite> allocaMap;
  Queue<ReplaceQueueElement> workList;
  HashMap<register, Entity> renameTable;
  ArrayList<block> linearOrder;
  ArrayList<block> outBlock;

  public static class EntryPair {
    public register reg;
    public String type;

    public EntryPair(register reg, String type) {
      this.reg = reg;
      this.type = type;
    }
  }

  public static class AllocaCite {
    public String type;
    public HashSet<block> defs;
    public HashSet<block> uses;

    public AllocaCite(String type) {
      this.type = type;
      defs = new HashSet<>();
      uses = new HashSet<>();
    }
  }

  public static class PhyRegister {
    public int id;
    public register reg;

    public PhyRegister(int id) {
      this.id = id;
      reg = null;
    }

    public PhyRegister(int id, register reg) {
      this.id = id;
      this.reg = reg;
    }
  }

  public static class ReplaceQueueElement {
    public block b;
    public HashMap<register, Entity> replaceval;

    public ReplaceQueueElement(block b, HashMap<register, Entity> replaceval) {
      this.b = b;
      this.replaceval = replaceval;
    }
  }

  public func() {
    entry = new ArrayList<>();
    args = new ArrayList<register>();
    allocaMap = new HashMap<>();
    workList = new LinkedList<>();
    renameTable = new HashMap<>();
    linearOrder = new ArrayList<>();
    outBlock = new ArrayList<>();
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

  public void prep() {
    HashSet<block> visited = new HashSet<>();
    if (entry.size() > 0) {
      entry.forEach(
        e -> allocaMap.put(e.reg, new AllocaCite(e.type))
      );
    }
    Queue<block> q = new LinkedList<>();
    q.add(headblock);
    while (q.size() > 0) {
      block current = q.poll();
      if (visited.contains(current)) {
        continue;
      }
      visited.add(current);
      if (current.statements.size() > 0) {
        for (statement s : current.statements) {
          if (s instanceof assign) {
            assign a = (assign)s;
            if (allocaMap.containsKey(a.left)) {
              allocaMap.get(a.left).defs.add(current);
            }
          } else if (s instanceof load) {
            load l = (load)s;
            if (allocaMap.containsKey(l.addr)) {
              allocaMap.get(l.addr).defs.add(current);
            }
          }
        }
      }
      if (current.next != null) {
        current.next.next().forEach(q::add);
        current.next.next().forEach(
          next -> next.pre.add(current)
        );
      }
    }
  }

  public void mem2reg() {
    domtree dom = new domtree(headblock);
    dom.build();
    dom.getfrontier();
    for (register b : allocaMap.keySet()) {
      Queue<block> q = new LinkedList<>();
      for (block defs : allocaMap.get(b).defs) {
        q.add(defs);
      }
      while (!q.isEmpty()) {
        block cur = q.poll();
        for (block frontier : cur.frontier) {
          if (frontier.phis.containsKey(b)) {
            continue;
          }
          phi tmp = new phi(new register(allocaMap.get(b).type), new ArrayList<>(), new ArrayList<>());
          frontier.phis.put(b, tmp);
          frontier.phisInOrder.add(tmp);
          q.add(frontier);
        }
      }
    }
    HashMap<register, Entity> replaceval = new HashMap<>();
    for (register keySet : allocaMap.keySet()) {
      replaceval.put(keySet, (allocaMap.get(keySet).type.equals("i1") ? new constant1(false) : (allocaMap.get(keySet).type.equals("i32") ? new constant32(0) : new nullptr())));
    }
    workList.add(new ReplaceQueueElement(headblock, replaceval));
    while (!workList.isEmpty()) {
      ReplaceQueueElement e = workList.poll();
      if (e.b.ismem2reg) {
        continue;
      }
      e.b.ismem2reg = true;
      for (register keySet : e.b.phis.keySet()) {
        phi p = e.b.phis.get(keySet);
        e.replaceval.put(keySet, p.dst);
      }
      for (int i = e.b.phisInOrder.size() - 1; i >= 0; i--) {
        e.b.statements.add(0, e.b.phisInOrder.get(i));
      }
      for (int i = 0; i < e.b.statements.size(); i++) {
        statement s = e.b.statements.get(i);
        if (s instanceof assign) {
          assign a = (assign)s;
          if (allocaMap.containsKey(a.left)) {
            if (renameTable.containsKey(a.right)) {
              e.replaceval.put(a.left, renameTable.get(a.right));
            } else {
              e.replaceval.put(a.left, a.right);
            }
            e.b.statements.remove(i);
            i--;
          }
        } else if (s instanceof load) {
          load l = (load)s;
          if (allocaMap.containsKey(l.addr)) {
            // e.b.statements.add(i, new let(l.reg, e.replaceval.get(l.addr)));
            // e.b.statements.remove(i + 1);
            renameTable.put(l.reg, e.replaceval.get(l.addr));
            e.b.statements.remove(i);
            i--;
          }
        }
      }
      if (e.b.next != null) {
        for (block nextbBlock : e.b.next.next()) {
          for (register keySet : nextbBlock.phis.keySet()) {
            nextbBlock.phis.get(keySet).srcs.add(e.replaceval.get(keySet));
            nextbBlock.phis.get(keySet).labels.add(e.b.name);
          }
          workList.add(new ReplaceQueueElement(nextbBlock, new HashMap<register, Entity>(e.replaceval)));
        }
      }
    }
  }

  public void rename() {
    Queue<block> q = new LinkedList<>();
    q.add(headblock);
    while (!q.isEmpty()) {
      block current = q.poll();
      if (current.isrename) {
        continue;
      }
      current.isrename = true;
      for (int i = 0; i < current.statements.size(); i++) {
        statement s = current.statements.get(i);
        s.rename(renameTable);
      }
      if (current.next != null) {
        current.next.rename(renameTable);;
        current.next.next().forEach(q::add);
      }
    }
  }

  public void analyze() {
    HashSet<block> visited = new HashSet<>();
    dfs(visited, headblock);
    for (block outBlock : outBlock) {
      outBlock.checkLive(new HashSet<>());
    }
    HashMap<register, Interval> intervalMap = new HashMap<>();
    int cnt = 0;
    for (int i = linearOrder.size() - 1; i >= 0; i--) {
      block current = linearOrder.get(i);
      for (statement s : current.statements) {
        for (register r : s.liveVarOut) {
          if (!intervalMap.containsKey(r)) {
            intervalMap.put(r, new Interval(cnt, cnt));
          } else {
            intervalMap.get(r).end = cnt;
          }
        }
      }
      cnt++;
    }
    PriorityQueue <register> pq = new PriorityQueue<>(new Comparator<register>() {
      @Override
      public int compare(register a, register b) {
        return a.interval.end.compareTo(b.interval.end);
      }
    });
    PriorityQueue <PhyRegister> regPool = new PriorityQueue<>(new Comparator<PhyRegister>() {
      @Override
      public int compare(PhyRegister a, PhyRegister b) {
        return a.reg.interval.end - b.reg.interval.end;
      }
    });
    intervalMap.forEach(
      (k, v) -> k.interval = v
    );
    for (int i = 3; i < 7; i++) {
      regPool.add(new PhyRegister(i));
    }
    while (!pq.isEmpty()) {
      register e = pq.poll();
      if (regPool.peek().reg.interval.end < e.interval.start) {
        PhyRegister pr = regPool.poll();
        regPool.add(new PhyRegister(pr.id, e));
        e.regId = pr.id;
      } else if (regPool.peek().reg.interval.end > e.interval.end) {
        PhyRegister pr = regPool.poll();
        regPool.add(new PhyRegister(pr.id, e));
        e.regId = pr.id;
        pr.reg.regId = -1;
      }
    }
  }

  public void dfs(HashSet<block> visited, block current) {
    if (visited.contains(current)) {
      return;
    }
    visited.add(current);
    if (current.next != null) {
      current.next.next().forEach(
        next -> dfs(visited, next)
        );
    } else {
      outBlock.add(current);
    }
    linearOrder.add(current);
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
        virtreg argsv = regAlloca.GetVirtReg(args.get(i));
        text.addAll(regAlloca.LoadToPhyReg(regAlloca.GetPhyReg(argsv), tmp));
        text.addAll(regAlloca.StorePhyReg(regAlloca.GetPhyReg(argsv), argsv));
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
      for (int i = 0; i < p.srcs.size(); i++) {
        block b = labelMap.get(p.labels.get(i));
        b.add(new let(p.dst, p.srcs.get(i)));
      }
    }
  }
}
