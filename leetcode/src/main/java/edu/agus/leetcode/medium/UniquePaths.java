package edu.agus.leetcode.medium;

public class UniquePaths {
  public int rec(int[][] mem, int r, int c, int m, int n) {
    if (r == c && r == 0) mem[r][c] = 1;
    else if (r >= m || r < 0) return 0;
    else if (c >= n || c < 0) return 0;
    else if (mem[r][c] != 0) return mem[r][c];
    else {
      mem[r][c] = rec(mem, r - 1, c, m, n) + rec(mem, r, c - 1, m, n);
    }
    return mem[r][c];
  }

  public int uniquePaths(int m, int n) {
    int[][] mem = new int[m][n];
    rec(mem, m - 1, n - 1, m, n);
    return mem[m - 1][n - 1];
  }
}
