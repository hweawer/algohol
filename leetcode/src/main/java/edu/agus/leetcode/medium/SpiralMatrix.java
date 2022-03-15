package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int len = m * n;
    List<Integer> res = new ArrayList<>(len);
    int left = 0;
    int right = n - 1;
    int top = 0;
    int bottom = m - 1;
    while (res.size() < len) {
      for (int j = left; j <= right; j++) res.add(matrix[top][j]);
      top++;
      for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
      right--;
      for (int j = right; j >= left; j--) res.add(matrix[bottom][j]);
      bottom--;
      for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
      left++;
    }
    return res;
  }
}
