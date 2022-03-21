package edu.agus.leetcode.medium;

import java.util.Arrays;

public class LargestSubmatrix {
  public int largestSubmatrix(int[][] matrix) {
    int[] heights = new int[matrix[0].length];
    int largestSubmatrix = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          heights[j] = 0;
        } else {
          heights[j] += 1;
        }
      }
      int[] rowHeights = heights.clone();
      Arrays.sort(rowHeights);
      for (int j = 0; j < rowHeights.length; j++) {
        largestSubmatrix = Math.max(largestSubmatrix, (rowHeights[j] * (rowHeights.length - j)));
      }
    }
    return largestSubmatrix;
  }
}
