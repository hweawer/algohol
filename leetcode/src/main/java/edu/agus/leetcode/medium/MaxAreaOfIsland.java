package edu.agus.leetcode.medium;

//todo: can it be done with disjoined set?
public class MaxAreaOfIsland {
  int max = 0;

  public int maxAreaOfIsland(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        max = Math.max(max, dfs(grid, i, j, m, n));
      }
    }
    return max;
  }

  public int dfs(int[][] grid, int i, int j, int m, int n) {
    if (grid[i][j] == 0) return 0;
    else {
      int res = 1;
      grid[i][j] = 0;
      if (j - 1 >= 0) {
        res += dfs(grid, i, j - 1, m, n);
      }
      if (j + 1 < n) {
        res += dfs(grid, i, j + 1, m, n);
      }
      if (i - 1 >= 0) {
        res += dfs(grid, i - 1, j, m, n);
      }
      if (i + 1 < m) {
        res += dfs(grid, i + 1, j, m, n);
      }
      return res;
    }
  }
}
