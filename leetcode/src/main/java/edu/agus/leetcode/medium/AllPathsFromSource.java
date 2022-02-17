package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSource {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> path = new ArrayList<>();

  void backtracking(int[][] graph, int i, int n) {
    if (i == n - 1) res.add(new ArrayList<>(path));
    else if (graph[i].length == 0) return;
    else {
      for (int j = 0; j < graph[i].length; j++) {
        path.add(graph[i][j]);
        backtracking(graph, graph[i][j], n);
        path.remove(path.size() - 1);
      }
    }
  }

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    path.add(0);
    backtracking(graph, 0, graph.length);
    return res;
  }
}
