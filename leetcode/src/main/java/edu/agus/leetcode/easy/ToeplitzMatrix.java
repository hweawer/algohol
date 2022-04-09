package edu.agus.leetcode.easy;

public class ToeplitzMatrix {
  public boolean isToeplitzMatrix(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i > 0 && j > 0) {
          if (matrix[i][j] != matrix[i - 1][j - 1]) return false;
        }
      }
    }

    return true;
  }
}
