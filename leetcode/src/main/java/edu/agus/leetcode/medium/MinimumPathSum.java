package edu.agus.leetcode.medium;

public class MinimumPathSum {
  public int rec(int[][] mem, int[][] grid, int r, int c, int m, int n) {
    if (r < 0 || r >= m) return Integer.MAX_VALUE;
    else if (c < 0 || c >= n) return Integer.MAX_VALUE;
    else if (r == c && r == 0) {
      mem[r][c] = grid[r][c];
      return mem[r][c];
    } else if (mem[r][c] != -1) return mem[r][c];
    else {
      mem[r][c] = Math.min(rec(mem, grid, r - 1, c, m, n), rec(mem, grid, r, c - 1, m, n)) + grid[r][c];
      return mem[r][c];
    }
  }

  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] mem = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        mem[i][j] = -1;
      }
    }
    return rec(mem, grid, m - 1, n - 1, m, n);
  }
}
