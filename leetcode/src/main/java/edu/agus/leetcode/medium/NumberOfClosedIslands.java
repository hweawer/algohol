package edu.agus.leetcode.medium;

public class NumberOfClosedIslands {
  int m;
  int n;

  public void dfs(int[][] grid, int i, int j) {
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return;
    grid[i][j] = 0;
    dfs(grid, i - 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i, j - 1);
    dfs(grid, i + 1, j);
  }

  public int closedIsland(int[][] grid) {
    m = grid.length;
    n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) dfs(grid, i, j);
      }
    }
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          res++;
          dfs(grid, i, j);
        }
      }
    }
    return res;
  }
}
