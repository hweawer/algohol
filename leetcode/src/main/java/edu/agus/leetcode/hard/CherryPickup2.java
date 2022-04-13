package edu.agus.leetcode.hard;

public class CherryPickup2 {
  public int cherryPickup(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][][] mem = new int[m][n][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          mem[i][j][k] = -1;
        }
      }
    }
    return dp(0, 0, n - 1, grid, mem);
  }

  int dp(int row, int col1, int col2, int[][] grid, int[][][] mem) {
    if (col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) {
      return 0;
    }
    if (mem[row][col1][col2] != -1) {
      return mem[row][col1][col2];
    }

    int result = 0;
    result += grid[row][col1];
    if (col1 != col2) {
      result += grid[row][col2];
    }

    if (row != grid.length - 1) {
      int max = 0;
      for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
        for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
          max = Math.max(max, dp(row + 1, newCol1, newCol2, grid, mem));
        }
      }
      result += max;
    }
    mem[row][col1][col2] = result;
    return result;
  }
}
