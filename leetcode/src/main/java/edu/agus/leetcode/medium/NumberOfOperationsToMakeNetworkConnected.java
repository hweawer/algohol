package edu.agus.leetcode.medium;

public class NumberOfOperationsToMakeNetworkConnected {
  int[] parents;
  int[] ranks;

  int find(int node) {
    if (node == parents[node]) return node;
    else {
      parents[node] = find(parents[node]);
      return parents[node];
    }
  }

  void union(int u, int v) {
    int ru = find(u);
    int rv = find(v);
    if (ru == rv) return;
    if (ranks[ru] > ranks[rv]) {
      parents[rv] = ru;
    } else {
      parents[ru] = rv;
      if (ranks[ru] == ranks[rv]) {
        ranks[rv]++;
      }
    }
  }

  int components() {
    int total = 0;
    for (int i = 0; i < parents.length; i++) {
      if (parents[i] == i) total++;
    }
    return total;
  }

  public int makeConnected(int n, int[][] connections) {
    if (connections.length < n - 1) return -1;
    parents = new int[n];
    ranks = new int[n];
    for (int i = 0; i < n; i++) parents[i] = i;
    for (int[] connection : connections) union(connection[0], connection[1]);
    return components() - 1;
  }
}
