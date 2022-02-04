package edu.agus.leetcode.medium;

public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    int max = 0;
    int[][] mem = new int[m][n];
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == '1') {
        mem[i][0] = 1;
        max = 1;
      }
    }
    for (int i = 0; i < n; i++) {
      if (matrix[0][i] == '1') {
        mem[0][i] = 1;
        max = 1;
      }
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == '1') {
          mem[i][j] = 1 + Math.min(mem[i - 1][j - 1], Math.min(mem[i][j - 1], mem[i - 1][j]));
        }
        max = Math.max(max, mem[i][j]);
      }
    }
    return max * max;
  }
}
