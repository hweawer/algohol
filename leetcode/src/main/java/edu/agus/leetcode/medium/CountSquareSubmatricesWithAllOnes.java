package edu.agus.leetcode.medium;

public class CountSquareSubmatricesWithAllOnes {
  public int countSquares(int[][] matrix) {
    int total = 0;
    int m = matrix.length;
    int n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      total += matrix[i][0];
    }
    for (int i = 0; i < n; i++) {
      total += matrix[0][i];
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 1) {
          matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1])) + 1;
        }
        total += matrix[i][j];
      }
    }
    return total;
  }
}
