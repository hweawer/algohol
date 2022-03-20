package edu.agus.leetcode.medium;

public class CountSubIslands {
  public void color(int[][] grid, int i, int j, int m, int n, int color) {
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return;
    grid[i][j] = color;
    color(grid, i - 1, j, m, n, color);
    color(grid, i, j + 1, m, n, color);
    color(grid, i + 1, j, m, n, color);
    color(grid, i, j - 1, m, n, color);
  }

  public boolean check(int[][] grid1, int[][] grid2, int i, int j, int m, int n, int color) {
    if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] != 1) return true;
    if (grid1[i][j] != color) return false;
    grid2[i][j] = color;

    boolean top = check(grid1, grid2, i - 1, j, m, n, color);
    boolean left = check(grid1, grid2, i, j + 1, m, n, color);
    boolean bot = check(grid1, grid2, i + 1, j, m, n, color);
    boolean right = check(grid1, grid2, i, j - 1, m, n, color);
    return top && left && bot && right;
  }

  public int countSubIslands(int[][] grid1, int[][] grid2) {
    int color = 2;

    int m = grid1.length;
    int n = grid1[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid1[i][j] == 1) color(grid1, i, j, m, n, color++);
      }
    }
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid2[i][j] == 1 && grid1[i][j] > 0) {
          if (check(grid1, grid2, i, j, m, n, grid1[i][j])) res++;
        }
      }
    }
    return res;
  }
}
