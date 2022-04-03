package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SatisfiabilityOfEqualityEquations {
  class UnionFind {
    Map<Integer, Integer> parent;
    Map<Integer, Integer> rank;

    public UnionFind(Set<Integer> vars) {
      parent = new HashMap();
      rank = new HashMap();
      for (int x : vars) {
        parent.put(x, x);
        rank.put(x, 1);
      }
    }

    int find(int v) {
      if (parent.get(v) == v) return v;
      else {
        int node = find(parent.get(v));
        parent.put(v, node);
        return node;
      }
    }

    boolean union(int u, int v) {
      int ru = find(u);
      int rv = find(v);

      if (ru == rv) return false;
      if (rank.get(ru) < rank.get(rv)) {
        parent.put(ru, rv);
      } else {
        parent.put(rv, ru);
        if (rank.get(ru) == rank.get(rv)) {
          int vv = rank.get(ru) + 1;
          rank.put(ru, vv);
        }
      }
      return true;
    }
  }

  public boolean equationsPossible(String[] equations) {
    Set<Integer> els = new HashSet();
    for (String s : equations) {
      els.add(s.charAt(0) - 'a');
      els.add(s.charAt(3) - 'a');
    }
    UnionFind uf = new UnionFind(els);

    for (String s : equations) {
      if (s.charAt(1) == '=') {
        uf.union(s.charAt(0) - 'a', s.charAt(3) - 'a');
      }
    }

    for (String s : equations) {
      if (s.charAt(1) == '!') {
        if (uf.find(s.charAt(0) - 'a') == uf.find(s.charAt(3) - 'a')) return false;
      }
    }
    return true;
  }
}
