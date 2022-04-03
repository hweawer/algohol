package edu.agus.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
  class UnionFind {
    int[] parent;
    int[] rank;
    int size;

    UnionFind(int n) {
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        rank[i] = 1;
      }
      size = n;
    }

    int find(int v) {
      if (parent[v] == v) return v;
      else {
        parent[v] = find(parent[v]);
        return parent[v];
      }
    }

    boolean union(int v, int u) {
      int vroot = find(v);
      int uroot = find(u);

      if (vroot == uroot) return false;

      if (rank[vroot] < rank[uroot]) {
        parent[vroot] = uroot;
      } else {
        parent[uroot] = vroot;
        if (rank[vroot] == rank[uroot]) {
          rank[vroot]++;
        }
      }
      return true;
    }

    int components() {
      for (int i = 0; i < size; i++) {
        find(i);
      }
      Set<Integer> distinct = new HashSet();
      for (int i = 0; i < size; i++) {
        distinct.add(parent[i]);
      }
      return distinct.size();
    }
  }

  public int earliestAcq(int[][] logs, int n) {
    Arrays.sort(logs, (x, y) -> x[0] - y[0]);
    UnionFind uf = new UnionFind(n);
    for (int[] log : logs) {
      uf.union(log[1], log[2]);
      if (uf.components() == 1) {
        return log[0];
      }
    }
    return -1;
  }
}
