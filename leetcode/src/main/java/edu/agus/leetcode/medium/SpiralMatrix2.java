package edu.agus.leetcode.medium;

public class SpiralMatrix2 {
  public int[][] generateMatrix(int n) {
    int[][] m = new int[n][n];
    int l = 0, r = n - 1, up = 0, down = n - 1;
    int cnt = 1;
    while (l <= r && up <= down) {
      for (int i = l; i <= r; ++i) m[up][i] = cnt++;
      for (int i = up + 1; i <= down; ++i) m[i][r] = cnt++;
      for (int i = r - 1; i >= l; --i) m[down][i] = cnt++;
      for (int i = down - 1; i > l; --i) m[i][l] = cnt++;
      l++;
      r--;
      up++;
      down--;
    }
    return m;
  }
}
