package edu.agus.leetcode.medium;

import java.util.Arrays;

public class SearchA2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] <= target && target <= matrix[i][n - 1]) {
        int ind = Arrays.binarySearch(matrix[i], target);
        if (ind < 0) return false;
        else return true;
      }
    }
    return false;
  }
}
