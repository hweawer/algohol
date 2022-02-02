package edu.agus.leetcode.medium;

public class MatrixBlockSum {
  public int[][] matrixBlockSum(int[][] mat, int k) {
    int m = mat.length;
    int n = mat[0].length;
    int[][] mem = new int[m + 1][n + 1];
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        mem[i][j] = mat[i - 1][j - 1] - mem[i - 1][j - 1] + mem[i - 1][j] + mem[i][j - 1];
      }
    }


    int[][] answer = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int i_min = Math.max(0, i - k);
        int i_max = Math.min(m - 1, i + k);
        int j_min = Math.max(0, j - k);
        int j_max = Math.min(n - 1, j + k);
        answer[i][j] = mem[i_max + 1][j_max + 1] + mem[i_min][j_min] - mem[i_min][j_max + 1] - mem[i_max + 1][j_min];
      }
    }
    return answer;
  }
}
