package edu.agus.leetcode.medium;

public class NumberOfEnclaves {
  int[][] table;
  int m;
  int n;

  public void dfs(int i, int j) {
    if (i < 0 || i >= m || j < 0 || j >= n || table[i][j] == 0) return;
    table[i][j] = 0;
    dfs(i - 1, j);
    dfs(i, j + 1);
    dfs(i + 1, j);
    dfs(i, j - 1);
  }

  public int numEnclaves(int[][] grid) {
    this.table = grid;
    this.m = grid.length;
    this.n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 1) dfs(i, j);
      }
    }
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) res++;
      }
    }
    return res;
  }
}
