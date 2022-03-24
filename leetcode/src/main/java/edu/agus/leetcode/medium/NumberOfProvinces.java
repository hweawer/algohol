package edu.agus.leetcode.medium;

import java.util.LinkedList;

public class NumberOfProvinces {
  void dfs(int i, LinkedList<Integer>[] adjastency, boolean[] visited) {
    if (visited[i]) return;
    visited[i] = true;
    for (int el : adjastency[i]) {
      dfs(el, adjastency, visited);
    }
  }

  public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    boolean[] visited = new boolean[n];
    LinkedList<Integer>[] adjastency = new LinkedList[n];

    for (int i = 0; i < n; i++) adjastency[i] = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (isConnected[i][j] == 1) {
          adjastency[i].add(j);
        }
      }
    }
    int total = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(i, adjastency, visited);
        total++;
      }
    }
    return total;
  }
}
