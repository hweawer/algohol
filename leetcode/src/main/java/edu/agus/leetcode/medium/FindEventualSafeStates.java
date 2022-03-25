package edu.agus.leetcode.medium;

import java.util.*;

public class FindEventualSafeStates {
  Map<Integer, Boolean> safeCache = new HashMap<>();
  boolean[] visited;

  boolean isSafe(int i, List<Integer>[] adjacency) {
    if (safeCache.containsKey(i)) return safeCache.get(i);
    else if (visited[i]) return false;
    else {
      visited[i] = true;
      for (int edge : adjacency[i]) {
        if (!isSafe(edge, adjacency)) {
          safeCache.put(i, false);
          return safeCache.get(i);
        }
      }
      visited[i] = false;
      safeCache.put(i, true);
      return safeCache.get(i);
    }
  }

  public List<Integer> eventualSafeNodes(int[][] graph) {
    int n = graph.length;
    visited = new boolean[n];
    List<Integer>[] adjacency = new List[n];
    for (int i = 0; i < n; i++) {
      adjacency[i] = new LinkedList<>();
      int[] edges = graph[i];
      if (graph[i].length == 0) safeCache.put(i, true);
      for (int e : edges) adjacency[i].add(e);
    }
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (isSafe(i, adjacency)) {
        res.add(i);
      }
    }
    return res;
  }
}
