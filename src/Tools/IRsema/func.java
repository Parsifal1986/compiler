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
import java.util.TreeSet;

import Tools.Pair;
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
  public HashSet<String> argsSet;
  public ArrayList<EntryPair> entry;
  public block headblock;
  public boolean hasCall = false;
  public ArrayList<block> outBlocks;
  HashMap<register, AllocaCite> allocaMap;
  Queue<ReplaceQueueElement> workList;
  HashMap<register, Entity> renameTable;
  ArrayList<block> linearOrder;
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

  public static double log2(double x) {
    if (x <= 0) {
      throw new IllegalArgumentException("Input must be greater than 0");
    }
    return Math.log(x) / Math.log(2);
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
    argsSet = new HashSet<>();
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

  public void global2local(HashMap<register, HashSet<func>> globalSet) {
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
          if (s instanceof load) {
            if (((load)s).addr instanceof register && ((register)((load)s).addr).isGlobal) {
              globalSet.get((register)((load)s).addr).add(this);
            }
          } else if (s instanceof assign) {
            assign st = (assign)s;
            if (st.left instanceof register && ((register)st.left).isGlobal) {
              globalSet.get((register)st.left).add(this);
            }
          } else if (s instanceof call) {
            hasCall = true;
          }
        }
      }
      if (current.next != null) {
        if (current.next.next().size() == 0) {
          outBlocks.add(current);
        }
        current.next.next().forEach(q::add);
      } else {
        outBlocks.add(current);
      }
    }
  }

  public void replace_var(register old, register newr) {
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
          if (s instanceof load) {
            load l = (load)s;
            if (l.addr == old) {
              l.addr = newr;
            }
          } else if (s instanceof assign) {
            assign a = (assign)s;
            if (a.left == old) {
              a.left = newr;
            }
          }
        }
      }
      if (current.next != null) {
        current.next.next().forEach(q::add);
      }
    }
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

  public void refine_branch() {
    HashSet<block> visited = new HashSet<>();
    Queue<block> q = new LinkedList<>();
    q.add(headblock);
    while (q.size() > 0) {
      block current = q.poll();
      if (visited.contains(current)) {
        continue;
      }
      visited.add(current);
      if (current.next != null && current.next instanceof branch) {
        branch b = (branch)current.next;
        if (b.condition != null) {
          if (b.condition instanceof register) {
            register r = (register)b.condition;
            for (int i = current.statements.size() - 1; i >= 0; i--) {
              statement s = current.statements.get(i);
              if (s.defVar.contains(r)) {
                if (s instanceof cmp) {
                  cmp c = (cmp)s;
                  asmbranch.Opcode op = null;
                  switch (c.op) {
                    case eq:
                      op = asmbranch.Opcode.BEQ;
                      break;
                    case ne:
                      op = asmbranch.Opcode.BNE;
                      break;
                    case slt:
                      op = asmbranch.Opcode.BLT;
                      break;
                    case sgt:
                      op = asmbranch.Opcode.BGT;
                      break;
                    case sle:
                      op = asmbranch.Opcode.BLE;
                      break;
                    case sge:
                      op = asmbranch.Opcode.BGE;
                      break;
                    default:
                      op = asmbranch.Opcode.BEQ;
                      break;
                  }
                  asmbranch newb = new asmbranch(c.src1, c.src2, b.trueBlock, b.falseBlock, op);
                  current.next = newb;
                  current.next.initialize();
                  current.statements.remove(i);
                }
                break;
              }
            }
          }
        }
        current.next.next().forEach(q::add);
      }
    }
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
    TreeSet <PhyRegister> regPool = new TreeSet<>(new Comparator<PhyRegister>() {
      @Override
      public int compare(PhyRegister a, PhyRegister b) {
        int endComparison = a.reg.interval.end.compareTo(b.reg.interval.end);
        if (endComparison == 0) {
          return a.id - b.id;
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
      Iterator<PhyRegister> it = regPool.iterator();
      ArrayList<PhyRegister> toBeAdd = new ArrayList<>();
      while (it.hasNext()) {
        PhyRegister pr = it.next();
        if (pr.reg.interval.end < e.interval.start) {
          it.remove();
          register tmp = new register("i32");
          tmp.interval = new Interval(-1, -1);
          pr.reg = tmp;
          toBeAdd.add(pr);
        } else {
          break;
        }
      }
      for (PhyRegister p : toBeAdd) {
        regPool.add(p);
      }
      if (regPool.first().reg.interval.end < e.interval.start) {
        PhyRegister pr = regPool.pollFirst();
        regPool.add(new PhyRegister(pr.id, e));
        e.regId = pr.id;
        calleeUsedReg.add(pr.id);
      } else if (regPool.last().reg.interval.end > e.interval.end) {
        PhyRegister pr = regPool.pollLast();
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
    }
    linearOrder.add(current);
  }
  
  public void clean_phi() {
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
      int cnt = 0;
      if (current.statements.size() > 0) {
        for (int i = 0; i < current.statements.size(); i++) {
          statement s = current.statements.get(i);
          if (s instanceof phi) {
            cnt++;
            phi p = (phi) s;
            current.allPhis.put(p.dst, p);
            current.allPhisInOrder.add(p);
            current.phiCnt.put(p, cnt);
            current.statements.remove(i);
            i--;
          }
        }
        current.firstPhi = current.statements.size();
      }
      if (current.next != null) {
        current.next.next().forEach(q::add);
      }
    }
    HashSet<block> hasTmpSet = new HashSet<>();
    for (block b : allBlocks) {
      HashMap<register, register> tmpMap = new HashMap<>();
      for (phi p : b.allPhisInOrder) {
      // for (phi p : b.allPhis.values()) {
        for (int i = 0; i < p.srcs.size(); i++) {
          block src = labelMap.get(p.labels.get(i));
          if (p.srcs.get(i) instanceof register) {
            register r = (register) p.srcs.get(i);
            // if (b.allPhis.containsKey(r) && b.allPhis.get(r) != p) {
            if (b.allPhis.containsKey(r) && b.phiCnt.get(b.allPhis.get(r)) < b.phiCnt.get(p)) {
              if (tmpMap.containsKey(r)) {
                p.srcs.set(i, tmpMap.get(r));
              } else {
                register tmp = new register(r.type);
                src.add(src.firstPhi, new let(tmp, r));
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

  public void scc_propagate() {
    boolean flag = true;
    HashMap<String, block> labelMap = new HashMap<>();
    HashSet<block> visited = new HashSet<>();
    Queue<block> q = new LinkedList<>();
    labelMap.put(headblock.name, headblock);
    q.add(headblock);
    while (q.size() > 0) {
      block current = q.poll();
      if (visited.contains(current)) {
        continue;
      }
      visited.add(current);
      labelMap.put(current.name, current);
      if (current.next != null) {
        current.next.next().forEach(q::add);
      }
    }
    while (flag) {
      flag = false;
      q = new LinkedList<>();
      visited = new HashSet<>();
      q.add(headblock);
      while (q.size() > 0) {
        block current = q.poll();
        if (visited.contains(current)) {
          continue;
        }
        visited.add(current);
        if (current.statements.size() > 0) {
          for (int i = 0; i < current.statements.size(); i++) {
            statement s = current.statements.get(i);
            if (s instanceof phi) {
              phi p = (phi)s;
              for (int j = 0; j < p.labels.size(); j++) {
                if (!labelMap.containsKey(p.labels.get(j))) {
                  p.srcs.remove(j);
                  p.labels.remove(j);
                  j--;
                }
              }
            }
            Pair<Boolean, statement> p = s.propagate();
            if (p.getKey()) {
              flag = true;
              if (p.getValue() == null) {
                current.statements.remove(i);
                i--;
              } else {
                current.statements.set(i, p.getValue());
              }
            }
          }
        }
        if (current.next != null) {
          Pair<Boolean, statement> p = current.next.propagate();
          if (p.getKey()) {
            flag = true;
            current.next = (control)p.getValue();
          }
          current.next.next().forEach(q::add);
        }
      }
      labelMap = new HashMap<>();
      for (block b : visited) {
        labelMap.put(b.name, b);
      }
    }
  }

  public void cs_elimination() {
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
        for (int i = 0; i < current.statements.size(); i++) {
          statement s = current.statements.get(i);
          if (s instanceof assign) {
            assign a = (assign)s;
            if (a.left == a.right) {
              current.statements.remove(i);
              i--;
            }
          }
        }
      }
      if (current.next != null) {
        current.next.next().forEach(q::add);
      }
    }
  }

  public void optimize_div() {
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
        for (int i = 0; i < current.statements.size(); i++) {
          statement s = current.statements.get(i);
          if (s instanceof binary && ((binary)s).op == binary.opcode.sdiv) {
            binary b = (binary)s;
            boolean flag = false;
            if (b.rhs instanceof constant32) {
              boolean neg = false;
              int val = ((constant32)b.rhs).value;
              if (val < 0) {
                val = -val;
                neg = true;
              }
              int sradd = Integer.numberOfTrailingZeros(val);
              val = val >> sradd;
              register tmpres = new register("i32");
              for (int l = 0; l < (int) Math.ceil(log2(val)); l++) {
                double m = Math.floor(((1L << (l + 32)) + (1L << l)) / val);
                if (m >= (double)(1L << (32 + l)) / val) {
                  register tmp = new register("i32");
                  current.statements.set(i, new binary(binary.opcode.mulhsu, b.lhs, new constant32((int)(long)(m)), tmp));
                  current.statements.add(i + 1, new binary(binary.opcode.ashr, tmp, new constant32(l + sradd), tmpres));
                  flag = true;
                  i = i + 1;
                  break;
                }
              }
              if (!flag) {
                int l = (int) Math.ceil(log2(val));
                double m = Math.floor(((1L << (l + 32)) + (1L << l)) / val);
                register tmp1 = new register("i32"), tmp2 = new register("i32"), tmp3 = new register("i32"), tmp4 = new register("i32");
                current.statements.set(i, new binary(binary.opcode.mulhsu, b.lhs, new constant32((int)((long)m - (1L << 32))), tmp1));
                current.statements.add(i + 1, new binary(binary.opcode.sub, b.lhs, tmp1, tmp2));
                current.statements.add(i + 2, new binary(binary.opcode.ashr, tmp2, new constant32(1), tmp3));
                current.statements.add(i + 3, new binary(binary.opcode.add, tmp3, tmp1, tmp4));
                current.statements.add(i + 4, new binary(binary.opcode.ashr, tmp4, new constant32(l + sradd - 1), tmpres));
                i = i + 4;
              }
              register tmpres2;
              if (neg) {
                tmpres2 = new register("i32");
                current.statements.add(i + 1, new binary(binary.opcode.sub, new constant32(0), tmpres, tmpres2));
                i = i + 1;
              } else {
                tmpres2 = tmpres;
              }
              register tmp = new register("i32");
              current.statements.add(i + 1, new cmp(tmp, tmpres2, new constant32(0), cmp.opcode.slt));
              current.statements.add(i + 2, new binary(binary.opcode.add, tmpres2, tmp, b.result));
              i = i + 2;
            }
          }
        }
      }
      if (current.next != null) {
        current.next.next().forEach(q::add);
      }
    }
  }

  public void dc_elimination() {
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

  public asmsection trans_to_asm() {
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
