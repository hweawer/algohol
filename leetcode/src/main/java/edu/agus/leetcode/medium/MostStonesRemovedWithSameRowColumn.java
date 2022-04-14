package edu.agus.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemovedWithSameRowColumn {
  class UnionFind {
    int[] parent;
    int[] rank;

    UnionFind(int n) {
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        rank[i] = 1;
      }
    }

    int find(int v) {
      if (v == parent[v]) return v;
      else {
        int node = find(parent[v]);
        parent[v] = node;
        return node;
      }
    }

    void union(int v, int u) {
      int vr = find(v);
      int vu = find(u);

      if (vr == vu) return;

      if (rank[vr] < rank[vu]) {
        parent[vr] = vu;
      } else {
        parent[vu] = vr;
        if (rank[vr] == rank[vu]) {
          rank[vr]++;
        }
      }
    }

    int components() {
      Set<Integer> set = new HashSet();
      for (int i = 0; i < parent.length; i++) {
        set.add(find(i));
      }
      return set.size();
    }
  }

  public int removeStones(int[][] stones) {
    UnionFind uf = new UnionFind(stones.length);
    for (int i = 0; i < stones.length; i++) {
      int x = stones[i][0];
      int y = stones[i][1];
      for (int j = i + 1; j < stones.length; j++) {
        if (stones[j][0] == x || stones[j][1] == y) {
          uf.union(i, j);
        }
      }
    }

    return stones.length - uf.components();
  }
}
