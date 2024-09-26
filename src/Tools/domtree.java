package Tools;

import java.util.HashMap;
import java.util.HashSet;

import Tools.IRsema.block;

public class domtree {
  block root;
  int cnt = 0;
  HashMap<block, Integer> dfn;
  HashMap<block, block> idom;
  HashMap<block, block> sdom;
  HashMap<block, block> min;
  HashMap<block, block> parent;
  HashMap<block, block> father;
  HashMap<Integer, block> pos;
  
  public domtree(block root) {
    this.root = root;
    dfn = new HashMap<>();
    idom = new HashMap<>();
    sdom = new HashMap<>();
    parent = new HashMap<>();
    father = new HashMap<>();
    min = new HashMap<>();
    pos = new HashMap<>();
  }

  public void dfs(block cur) {
    dfn.put(cur, ++cnt);
    pos.put(cnt, cur);
    father.put(cur, cur);
    sdom.put(cur, cur);
    min.put(cur, cur);
    if (cur.next != null) {
      for (block next : cur.next.next()) {
        if (!dfn.containsKey(next)) {
          dfs(next);
          parent.put(next, cur);
        }
      }
    }
  }

  public block find(block cur) {
    if (father.get(cur) == cur) {
      return cur;
    }
    block tmp = find(father.get(cur));
    father.put(cur, find(tmp));
    if (dfn.get(sdom.get(min.get(father.get(cur)))) < dfn.get(sdom.get(min.get(cur)))) {
      min.put(cur, min.get(father.get(cur)));
    }
    return father.get(cur);
  }

  public void build() {
    dfs(root);
    for (int i = cnt; i > 2; i--) {
      block cur = pos.get(i);
      int res = Integer.MAX_VALUE;
      for (block prev : cur.pre) {
        if (!dfn.containsKey(prev)) {
          continue;
        }
        find(prev);
        if (dfn.get(prev) < dfn.get(cur)) {
          res = Math.min(res, dfn.get(prev));
        } else {
          res = Math.min(res, dfn.get(sdom.get(min.get(prev))));
        }
      }
      sdom.put(cur, pos.get(res));
      father.put(cur, parent.get(cur));
      sdom.get(cur).e.add(cur);
      cur = parent.get(cur);
      for (block v : cur.e) {
        find(v);
        if (sdom.get(min.get(v)) == cur) {
          idom.put(v, cur);
        } else {
          idom.put(v, min.get(v));
        }
      }
      cur.e.clear();
    }
    for (int i = 2; i < cnt; i++) {
      block cur = pos.get(i);
      if (idom.get(cur) != sdom.get(cur)) {
        idom.put(cur, idom.get(idom.get(cur)));
      }
    }
  }

  public block idom(block cur) {
    return idom.get(cur);
  }

  public void getfrontier() {
    for (block cur : dfn.keySet()) {
      if (cur.pre.size() <= 1) {
        continue;
      }
      for (block p : cur.pre) {
        block runner = p;
        while (runner != idom.get(cur)) {
          runner.frontier.add(cur);
          runner = idom.get(runner);
        }
      }
    }
  }

  public HashSet<block> domfrontier(block cur) {
    return cur.frontier;
  }
}
