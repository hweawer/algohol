package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PossibleBipartition {
  public boolean possibleBipartition(int n, int[][] dislikes) {
    int[] visited = new int[n + 1];
    Map<Integer, Set<Integer>> dict = new HashMap();
    for (int i = 1; i <= n; i++) dict.put(i, new HashSet());
    for (int[] dislike : dislikes) {
      dict.get(dislike[0]).add(dislike[1]);
      dict.get(dislike[1]).add(dislike[0]);
    }

    for (int i = 1; i <= n; i++) {
      if (visited[i] == 0 && !dfs(dict, 1, visited, i)) return false;
    }
    return true;
  }

  boolean dfs(Map<Integer, Set<Integer>> adj, int color, int[] visited, int i) {
    if (visited[i] == color) return true;
    if (visited[i] != 0) return false;
    visited[i] = color;
    for (int en : adj.get(i)) {
      if (!dfs(adj, -color, visited, en)) return false;
    }
    return true;
  }
}
