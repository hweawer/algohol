package edu.agus.leetcode.medium;

public class RedundantConnection {
  static class UnionFind {
    int[] parent;
    int[] rank;

    UnionFind(int n) {
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    int find(int v) {
      if (parent[v] == v) return v;
      else {
        parent[v] = find(parent[v]);
        return parent[v];
      }
    }

    boolean union(int v, int u) {
      int vr = find(v);
      int vu = find(u);

      if (vr == vu) return false;

      if (rank[vr] < rank[vu]) {
        parent[vr] = vu;
      } else {
        parent[vu] = vr;
        if (rank[vr] == rank[vu]) {
          rank[vr]++;
        }
      }

      return true;
    }
  }

  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;
    UnionFind uf = new UnionFind(n);
    for (int[] e : edges) {
      if (!uf.union(e[0] - 1, e[1] - 1)) {
        return e;
      }
    }
    return new int[]{-1, -1};
  }
}
