package edu.agus.leetcode.medium;

public class UniquePaths2 {
  public int rec(int[][] obstacleGrid, int[][] mem, int r, int c, int m, int n) {
    if (r == c && c == 0) return 1;
    else if (r < 0 || r >= m) return 0;
    else if (c < 0 || c >= n) return 0;
    else if (mem[r][c] != 0) return mem[r][c];
    else {
      int val = 0;
      if (r > 0 && obstacleGrid[r - 1][c] != 1) {
        val += rec(obstacleGrid, mem, r - 1, c, m, n);
      }
      if (c > 0 && obstacleGrid[r][c - 1] != 1) {
        val += rec(obstacleGrid, mem, r, c - 1, m, n);
      }
      mem[r][c] = val;
      return mem[r][c];
    }
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    if (obstacleGrid[m - 1][n - 1] == 1) return 0;
    int[][] mem = new int[m][n];
    return rec(obstacleGrid, mem, m - 1, n - 1, m, n);
  }
}
