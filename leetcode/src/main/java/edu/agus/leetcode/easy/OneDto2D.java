package edu.agus.leetcode.easy;

public class OneDto2D {
  public int[][] construct2DArray(int[] original, int m, int n) {
    if (m * n != original.length) return new int[][] {};
    int[][] matrix = new int[m][n];
    int ind = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = original[ind];
        ind++;
      }
    }
    return matrix;
  }
}
