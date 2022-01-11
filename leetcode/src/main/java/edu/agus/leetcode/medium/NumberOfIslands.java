package edu.agus.leetcode.medium;

public class NumberOfIslands {
  public void dfs(char[][] grid, int i, int j, int m, int n) {
    if (grid[i][j] == '0') return;
    else {
      grid[i][j] = '0';
      if (j - 1 >= 0) {
        dfs(grid, i, j - 1, m, n);
      }
      if (j + 1 < n) {
        dfs(grid, i, j + 1, m, n);
      }
      if (i - 1 >= 0) {
        dfs(grid, i - 1, j, m, n);
      }
      if (i + 1 < m) {
        dfs(grid, i + 1, j, m, n);
      }
    }
  }

  public int numIslands(char[][] grid) {
    int res = 0;
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          res++;
          dfs(grid, i, j, m, n);
        }
      }
    }
    return res;
  }
}
