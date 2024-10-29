package codegen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import Tools.IRsema.declaration;
import Tools.IRsema.func;
import Tools.IRsema.globalvar;
import Tools.IRsema.register;
import Tools.IRsema.statement;

public class Global2Localer {
  private ArrayList<func> functions;
  private declaration decls;

  public Global2Localer(ArrayList<func> functions, declaration decls) {
    this.functions = functions;
    this.decls = decls;
  }
  
  public void global2local() {
    HashMap<register, String> globalProperty = new HashMap<>();
    HashMap<register, HashSet<func>> globalSet = new HashMap<>();
    HashSet<register> discard = new HashSet<>();
    for (statement s : decls.global) {
      if (s instanceof globalvar) {
        globalvar g = (globalvar) s;
        if (!globalSet.containsKey(g.reg)) {
          globalSet.put(g.reg, new HashSet<>());
          globalProperty.put(g.reg, g.type);
        }
      }
    }
    for (func functions : functions) {
      functions.global2local(globalSet);
    }
    for (register keySet : globalSet.keySet()) {
      if (globalSet.get(keySet).size() == 1) {
        keySet.isGlobal = false;
        Iterator<func> it = globalSet.get(keySet).iterator();
        it.next().entry.add(new func.EntryPair(keySet, globalProperty.get(keySet)));
        discard.add(keySet);
      }
    }
    for (int i = 0; i < decls.global.size(); i++) {
      if (decls.global.get(i) instanceof globalvar) {
        globalvar g = (globalvar) decls.global.get(i);
        if (discard.contains(g.reg)) {
          decls.global.remove(i);
          i--;
        }
      }
    }
  }
}
