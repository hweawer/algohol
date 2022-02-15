package edu.agus.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    Set<Integer> rows = new HashSet<>();
    Set<Integer> columns = new HashSet<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          columns.add(j);
        }
      }
    }

    for (int row : rows) {
      for (int j = 0; j < n; j++) {
        matrix[row][j] = 0;
      }
    }

    for (int column : columns) {
      for (int i = 0; i < m; i++) {
        matrix[i][column] = 0;
      }
    }
  }
}
