package Tools.IRsema;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import Tools.Pair;

import Tools.Entity;
import Tools.RISCVsema.command;
import codegen.RegAlloca;

public class phi extends statement {
  public register dst;
  public ArrayList<Entity> srcs;
  public ArrayList<String> labels;

  public phi(register dst, ArrayList<Entity> srcs, ArrayList<String> labels) {
    this.dst = dst;
    this.srcs = srcs;
    this.labels = labels;
  }

  @Override
  public void print(PrintStream out) {
    out.print(dst.tostring() + " = phi " + dst.type + " ");
    for (int i = 0; i < srcs.size(); i++) {
      out.print("[ " + srcs.get(i).tostring() + ", %" + labels.get(i) + " ]");
      if (i != srcs.size() - 1) {
        out.print(", ");
      }
    }
    out.println();
  }

  @Override
  public ArrayList<command> toasm(RegAlloca regAlloc) {
    return null;
  }

  @Override
  public void rename(HashMap<register, Entity> renameMap) {
    for (int i = 0; i < srcs.size(); i++) {
      if (srcs.get(i) instanceof register && renameMap.containsKey(srcs.get(i))) {
        srcs.set(i, renameMap.get(srcs.get(i)));
      }
    }
    return;
  }

  @Override
  public Pair<Boolean, statement> propagate() {
    if (srcs.size() == 1) {
      if (srcs.get(0) instanceof register) {
        if (((register) srcs.get(0)).isConst) {
          dst.isConst = true;
          dst.value = ((register)srcs.get(0)).value;
        }
      } else {
        dst.isConst = true;
        dst.value = srcs.get(0);
      }
      return new Pair<Boolean, statement>(true, null);
    }
    for (int i = 0; i < srcs.size(); i++) {
      if (srcs.get(i) instanceof register) {
        if (((register) srcs.get(i)).isConst) {
          srcs.set(i, ((register) srcs.get(i)).value);
        }
      }
    }
    return new Pair<Boolean, statement>(false, this);
  }

  @Override
  public void initialize() {
    for (Entity src : srcs) {
      if (src instanceof register) {
        if (!((register) src).isGlobal) {
          liveVarIn.add(((register) src));
        }
      }
    }
    if (!dst.isGlobal) {
      defVar.add(dst);
    }
  }
}
