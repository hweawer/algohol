package edu.agus.leetcode.medium;

public class MinFallingPathSum {
  public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int[][] mem = new int[n][n];
    System.arraycopy(matrix[0], 0, mem[0], 0, n);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int val = matrix[i][j];
        if (j == 0) {
          mem[i][j] = Math.min(val + mem[i - 1][j], val + mem[i - 1][j + 1]);
        } else if (j == n - 1) {
          mem[i][j] = Math.min(val + mem[i - 1][j], val + mem[i - 1][j - 1]);
        } else {
          mem[i][j] = Math.min(val + mem[i - 1][j - 1], Math.min(val + mem[i - 1][j], val + mem[i - 1][j + 1]));
        }
      }
    }
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      res = Math.min(res, mem[n - 1][i]);
    }
    return res;
  }
}
