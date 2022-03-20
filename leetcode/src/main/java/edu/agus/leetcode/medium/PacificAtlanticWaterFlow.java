package edu.agus.leetcode.medium;

import java.util.*;

public class PacificAtlanticWaterFlow {
  static class Pair {
    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Pair pair = (Pair) o;
      return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  private int[][] grid;
  private int m;
  private int n;

  public void dfs(boolean[][] visited, Set<Pair> reachable, int i, int j, int prev) {
    if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] < prev) return;
    visited[i][j] = true;
    reachable.add(new Pair(i, j));
    int val = grid[i][j];
    dfs(visited, reachable, i - 1, j, val);
    dfs(visited, reachable, i, j + 1, val);
    dfs(visited, reachable, i + 1, j, val);
    dfs(visited, reachable, i, j - 1, val);
  }

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    Set<Pair> pacific = new HashSet<>();
    Set<Pair> atlantic = new HashSet<>();
    grid = heights;
    m = heights.length;
    n = heights[0].length;
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      dfs(visited, pacific, i, 0, heights[i][0]);
    }
    for (int i = 0; i < n; i++) {
      dfs(visited, pacific, 0, i, heights[0][i]);
    }
    visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      dfs(visited, atlantic, i, n - 1, heights[i][n - 1]);
    }
    for (int i = 0; i < n; i++) {
      dfs(visited, atlantic, m - 1, i, heights[m - 1][i]);
    }
    pacific.retainAll(atlantic);
    List<List<Integer>> ans = new ArrayList<>();
    for (Pair p : pacific) {
      List<Integer> pair = new ArrayList<>();
      pair.add(p.x);
      pair.add(p.y);
      ans.add(pair);
    }
    return ans;
  }

  public static void main(String[] args) {
    PacificAtlanticWaterFlow pawf = new PacificAtlanticWaterFlow();
    int[][] in = new int[][]{
        {1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}
    };
    pawf.pacificAtlantic(in);
  }
}
