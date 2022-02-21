package edu.agus.leetcode.medium;

import java.util.Arrays;

public class SearchA2DMatrix2 {
  // i am too lazy to go sorting by columns
  // it must go by diag
  public static boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix[0].length;
    for (int[] ints : matrix) {
      if (Arrays.binarySearch(ints, 0, n, target) >= 0) return true;
    }
    return false;
  }
}
