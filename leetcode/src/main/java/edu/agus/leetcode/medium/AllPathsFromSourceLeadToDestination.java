package edu.agus.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AllPathsFromSourceLeadToDestination {
  boolean hasCycle = false;
  boolean reachable = false;
  boolean end = true;
  Set<Integer> visited = new HashSet();
  int d;

  List<Integer>[] adj;

  void dfs(int source) {
    if (hasCycle || !end) return;
    if (visited.contains(source)) {
      hasCycle = true;
      return;
    }

    if (source == d) {
      reachable = true;
    }

    if (source != d && adj[source].isEmpty()) {
      end = false;
    }

    visited.add(source);
    for (int node : adj[source]) {
      dfs(node);
    }
    visited.remove(source);
  }

  public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
    this.d = destination;
    adj = new LinkedList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new LinkedList();
    }

    for (int[] edge : edges) {
      int from = edge[0];
      int to = edge[1];

      adj[from].add(to);
    }

    dfs(source);
    return !hasCycle && end && reachable;
  }
}
