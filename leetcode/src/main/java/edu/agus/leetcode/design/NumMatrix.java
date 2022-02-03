package edu.agus.leetcode.design;

class NumMatrix {
  int[][] mem;
  int[][] matrix;

  public NumMatrix(int[][] matrix) {
    this.matrix = matrix;
    int m = matrix.length;
    int n = matrix[0].length;
    mem = new int[m + 1][n + 1];
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        mem[i][j] = matrix[i - 1][j - 1] + mem[i - 1][j] + mem[i][j - 1] - mem[i - 1][j - 1];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return mem[row2 + 1][col2 + 1] - mem[row1][col2 + 1] - mem[row2 + 1][col1] + mem[row1][col1];
  }
}
