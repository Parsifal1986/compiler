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
import Tools.RISCVsema.arithmetic_i;
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
  ArrayList<block> outBlocks;
  HashSet<Integer> calleeUsedReg;

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
    public ArrayList<block> defsInOrder;
    public HashSet<block> uses;
    public HashSet<block> usesInOrder;

    public AllocaCite(String type) {
      this.type = type;
      defs = new HashSet<>();
      defsInOrder = new ArrayList<>();
      uses = new HashSet<>();
      usesInOrder = new HashSet<>();
    }
  }

  public static class PhyRegister {
    public int id;
    public register reg;

    public PhyRegister(int id) {
      this.id = id;
      reg = new register("i32");
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

  public static class VitalVarElement {
    public block b;
    public HashSet<register> vitalVar;

    public VitalVarElement(block b, HashSet<register> vitalVar) {
      this.b = b;
      this.vitalVar = vitalVar;
    }
  }

  public func() {
    entry = new ArrayList<>();
    args = new ArrayList<register>();
    allocaMap = new HashMap<>();
    workList = new LinkedList<>();
    renameTable = new HashMap<>();
    linearOrder = new ArrayList<>();
    outBlocks = new ArrayList<>();
    calleeUsedReg = new HashSet<>();
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
      if (current.isPrint) {
        continue;
      }
      current.isPrint = true;
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
              if (!allocaMap.get(a.left).defs.contains(current)) {
                allocaMap.get(a.left).defs.add(current);
                allocaMap.get(a.left).defsInOrder.add(current);
              }
            }
          } else if (s instanceof load) {
            load l = (load)s;
            if (allocaMap.containsKey(l.addr)) {
              if (!allocaMap.get(l.addr).uses.contains(current)) {
                allocaMap.get(l.addr).uses.add(current);
                allocaMap.get(l.addr).usesInOrder.add(current);
              }
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
      for (block defs : allocaMap.get(b).defsInOrder) {
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
      if (e.b.isMem2reg) {
        continue;
      }
      e.b.isMem2reg = true;
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
      if (current.isRename) {
        continue;
      }
      current.isRename = true;
      for (int i = 0; i < current.statements.size(); i++) {
        statement s = current.statements.get(i);
        s.rename(renameTable);
      }
      if (current.next != null) {
        current.next.rename(renameTable);
        current.next.next().forEach(q::add);
      }
    }
  }

  public void process() {
    HashSet<block> visited = new HashSet<>();
    dfs(visited, headblock);
  }

  public void analyze() {
    HashMap<register, Interval> intervalMap = new HashMap<>();
    ArrayList<register> argsReg = new ArrayList<>();
    for (int i = 0; i < Math.min(8, args.size()); i++) {
      register tmp = new register(args.get(i).type);
      tmp.interval = new Interval(1, i + 1);
      argsReg.add(tmp);
      intervalMap.put(args.get(i), new Interval(i + 1, i + 1));
    }
    for (block outBlock : outBlocks) {
      outBlock.checkLive(new HashSet<>());
    }
    int cnt = Math.min(8, args.size()) + 1;
    for (int i = linearOrder.size() - 1; i >= 0; i--) {
      block current = linearOrder.get(i);
      for (statement s : current.statements) {
        for (register r : s.defVar) {
          if (!intervalMap.containsKey(r)) {
              intervalMap.put(r, new Interval(cnt, cnt));
          } else {
            intervalMap.get(r).end = cnt;
          }
        }
        for (register r : s.liveVarIn) {
          if (!intervalMap.containsKey(r)) {
            intervalMap.put(r, new Interval(cnt, cnt));
          } else {
            intervalMap.get(r).end = cnt;
          }
        }
        cnt++;
      }
      if (current.next != null) {
        statement s = current.next;
        for (register r : s.defVar) {
          if (!intervalMap.containsKey(r)) {
            intervalMap.put(r, new Interval(cnt, cnt));
          }
        }
        for (register r : s.liveVarIn) {
          if (!intervalMap.containsKey(r)) {
            intervalMap.put(r, new Interval(cnt, cnt));
          } else {
            intervalMap.get(r).end = cnt;
          }
        }
        cnt++;
      }
    }
    PriorityQueue <register> pq = new PriorityQueue<>(new Comparator<register>() {
      @Override
      public int compare(register a, register b) {
        int startComparison = a.interval.start.compareTo(b.interval.start);
        if (startComparison == 0) {
          return a.name.compareTo(b.name);
        }
        return startComparison;
      }
    });
    PriorityQueue <PhyRegister> regPool = new PriorityQueue<>(new Comparator<PhyRegister>() {
      @Override
      public int compare(PhyRegister a, PhyRegister b) {
        int endComparison = a.reg.interval.end.compareTo(b.reg.interval.end);
        if (endComparison == 0) {
          return a.reg.regId - b.reg.regId;
        }
        return endComparison;
      }
    });
    for (register keySet : intervalMap.keySet()) {
      keySet.interval = intervalMap.get(keySet);
      pq.add(keySet);
    }
    for (Integer i : RegAlloca.allocableRegList) {
      PhyRegister tmp = new PhyRegister(i);
      if (10 <= i && i < 10 + argsReg.size()) {
        tmp.reg = argsReg.get(i - 10);
      }
      regPool.add(tmp);
    }
    while (!pq.isEmpty()) {
      register e = pq.poll();
      if (regPool.peek().reg.interval.end < e.interval.start) {
        PhyRegister pr = regPool.poll();
        regPool.add(new PhyRegister(pr.id, e));
        e.regId = pr.id;
        calleeUsedReg.add(pr.id);
      } else if (regPool.peek().reg.interval.end > e.interval.end) {
        PhyRegister pr = regPool.poll();
        regPool.add(new PhyRegister(pr.id, e));
        e.regId = pr.id;
        pr.reg.regId = -1;
        calleeUsedReg.add(pr.id);
      }
    }
  }

  public void dfs(HashSet<block> visited, block current) {
    if (visited.contains(current)) {
      return;
    }
    visited.add(current);
    if (current.statements.size() > 0) {
      for (statement s : current.statements) {
        s.initialize();
      }
    }
    if (current.next != null) {
      current.next.initialize();
      for (block next : current.next.next()) {
        dfs(visited, next);
      }
      if (current.next.next().size() == 0) {
        outBlocks.add(current);
      }
    } else {
      outBlocks.add(current);
    }
    linearOrder.add(current);
  }
  
  public void cleanPhi() {
    HashMap<String, block> labelMap = new HashMap<>();
    Queue<block> q = new LinkedList<block>();
    ArrayList<block> allBlocks = new ArrayList<>();
    labelMap.put(headblock.name, headblock);
    q.add(headblock);
    while (q.size() > 0) {
      block current = q.poll();
      labelMap.put(current.name, current);
      if (current.isClean) {
        continue;
      }
      current.isClean = true;
      allBlocks.add(current);
      if (current.statements.size() > 0) {
        Iterator<statement> it = current.statements.iterator();
        while (it.hasNext()) {
          statement s = it.next();
          if (s instanceof phi) {
            phi p = (phi) s;
            current.allPhis.put(p.dst, p);
            it.remove();
          }
        }
      }
      if (current.next != null) {
        current.next.next().forEach(q::add);
      }
    }
    HashSet<block> hasTmpSet = new HashSet<>();
    for (block b : allBlocks) {
      HashMap<register, register> tmpMap = new HashMap<>();
      for (phi p : b.allPhis.values()) {
        for (int i = 0; i < p.srcs.size(); i++) {
          block src = labelMap.get(p.labels.get(i));
          if (p.srcs.get(i) instanceof register) {
            register r = (register) p.srcs.get(i);
            if (b.allPhis.containsKey(r)) {
              if (tmpMap.containsKey(r)) {
                p.srcs.set(i, tmpMap.get(r));
              } else {
                register tmp = new register(r.type);
                src.addInFront(new let(tmp, r));
                tmpMap.put(r, tmp);
                p.srcs.set(i, tmp);
              }
            }
          }
          boolean flag = false;
          if (src.next instanceof branch) {
            for (block next : src.next.next()) {
              if (next.allPhis.size() != 0 && next != b) {
                block tmp;
                if (!src.tmpBlocks.containsKey(b)) {
                  tmp = new block("tmpPhis");
                  src.tmpBlocks.put(b, tmp);
                  hasTmpSet.add(src);
                  tmp.pre.add(src);
                  tmp.next = new branch(null, b, null);
                } else {
                  tmp = src.tmpBlocks.get(b);
                }
                tmp.add(new let(p.dst, p.srcs.get(i)));
                flag = true;
                break;
              }
            }
          }
          if (!flag) {
            src.add(new let(p.dst, p.srcs.get(i)));
          }
        }
      }
    }

    for (block srcBlock : hasTmpSet) {
      branch br = (branch) srcBlock.next;
      for (block values : srcBlock.tmpBlocks.values()) {
        block next = values.next.next().get(0);
        if (br.trueBlock == next) {
          br.trueBlock = values;
        } else {
          br.falseBlock = values;
        }
        next.pre.remove(srcBlock);
        next.pre.add(values);
      }
    }
  }

  public void dce() {
    HashSet<register> haveChecked = new HashSet<>();
    Queue<register> toBeLive = new LinkedList<>();
    HashMap<register, ArrayList<statement>> defMap = new HashMap<>();
    HashSet<block> visited = new HashSet<>();
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
          if (s instanceof assign || s instanceof call) {
            s.isDead = false;
            toBeLive.addAll(s.liveVarIn);
          }
          for (register r : s.defVar) {
            if (!defMap.containsKey(r)) {
              defMap.put(r, new ArrayList<>());
            }
            defMap.get(r).add(s);
          }
        }
      }
      if (current.next != null) {
        current.next.next().forEach(q::add);
        toBeLive.addAll(current.next.liveVarIn);
      }
    }
    visited.clear();
    while (toBeLive.size() > 0) {
      register current = toBeLive.poll();
      if (haveChecked.contains(current)) {
        continue;
      }
      haveChecked.add(current);
      if (!defMap.containsKey(current)) {
        continue;
      }
      for (statement s : defMap.get(current)) {
        if (!s.isDead) {
          continue;
        }
        for (register r : s.liveVarIn) {
          toBeLive.add(r);
        }
        s.isDead = false;
      }
    }
    Queue<block> q2 = new LinkedList<>();
    q2.add(headblock);
    while (q2.size() > 0) {
      block current = q2.poll();
      if (visited.contains(current)) {
        continue;
      }
      visited.add(current);
      if (current.statements.size() > 0) {
        Iterator<statement> it = current.statements.iterator();
        while (it.hasNext()) {
          statement s = it.next();
          if (s.isDead) {
            it.remove();
          }
        }
      }
      if (current.next != null) {
        current.next.next().forEach(q2::add);
      }
    }
  }

  public asmsection trans() {
    textsection text = new textsection(name, true);
    RegAlloca regAlloca = new RegAlloca();
    text.add(new mv(regAlloca.GetPhyReg("s0"), regAlloca.GetPhyReg("sp")));
    HashMap<Integer, register> calleeSavedMap = new HashMap<>();
    for (Integer keySet : calleeUsedReg) {
      if (regAlloca.calleeSaveRegMap.containsKey(keySet)) {
        text.addAll(regAlloca.StorePhyReg(regAlloca.GetPhyReg(keySet), regAlloca.GetVirtReg(regAlloca.calleeSaveRegMap.get(keySet))));
        calleeSavedMap.put(keySet, regAlloca.calleeSaveRegMap.get(keySet));
      }
    }
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
    // if (entry.size() > 0) {
    //   for (EntryPair entry : entry) {
    //     text.addAll((new alloca(entry.reg, entry.type)).toAsm(regAlloca));
    //   }
    //   text.add(new control_i(regAlloca.GetPhyReg("zero"), headblock.name));
    // }
    Queue<block> q = new LinkedList<block>();
    q.add(headblock);
    while (q.size() > 0) {
      block current = q.poll();
      if (current.isTrans) {
        continue;
      }
      current.isTrans = true;
      ArrayList<command> tmp = new ArrayList<>();
      if (current.statements.size() > 0) {
        for (int i = 0; i < current.statements.size(); i++) {
          tmp.addAll(current.statements.get(i).toasm(regAlloca));
        }
      }
      if (current.next != null) {
        tmp.addAll(current.next.toasm(regAlloca));
        if (current.next.next().size() == 0) {
          for (Integer keySet : calleeSavedMap.keySet()) {
            tmp.addAll(tmp.size() - 1, regAlloca.LoadToPhyReg(regAlloca.GetPhyReg(keySet), regAlloca.GetVirtReg(calleeSavedMap.get(keySet))));
          }
        }
        for (int i = current.next.next().size() - 1; i >= 0; i--) {
          q.add(current.next.next().get(i));
        }
      } else {
        if (name.equals("main")) {
          tmp.add(new li(regAlloca.GetPhyReg("a0"), new immnum(0)));
        }
        for (Integer keySet : calleeSavedMap.keySet()) {
          tmp.addAll(regAlloca.LoadToPhyReg(regAlloca.GetPhyReg(keySet), regAlloca.GetVirtReg(calleeSavedMap.get(keySet))));
        }
        tmp.add(new ret());
      }
      tmp.get(0).label = current.name;
      text.addAll(tmp);
    }
    int stacksize = (int)Math.ceil(1.0 * regAlloca.getTotalSpace() / 16) * 16;
    if (-2048 < stacksize && stacksize <= 2048) {
      text.add(1, new arithmetic_i(regAlloca.GetPhyReg("sp"), regAlloca.GetPhyReg("sp"), new immnum(-stacksize), arithmetic_i.Opcode.addi));
    } else {
      text.add(1, new arithmetic_r(regAlloca.GetPhyReg("sp"), regAlloca.GetPhyReg("sp"), regAlloca.GetPhyReg("t0"), arithmetic_r.Opcode.add));
      text.add(1, new li(regAlloca.GetPhyReg("t0"), new immnum(-stacksize)));
    }
    text.stacksize = stacksize;
    return text;
  }
}
