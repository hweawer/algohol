package edu.agus.leetcode.medium;

public class DiagonalTraverse {
  public int[] findDiagonalOrder(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    int x = 0;
    int y = 0;
    int[] res = new int[m * n];
    int p = 0;
    boolean up = true;
    while (x < m && y < n) {
      res[p++] = mat[x][y];
      int new_row = x + (up ? -1 : 1);
      int new_column = y + (up ? 1 : -1);
      if (new_row < 0 || new_column < 0 || new_row == m || new_column == n) {
        if (up) {
          x += (y == n - 1 ? 1 : 0);
          y += (y < n - 1 ? 1 : 0);
        } else {
          y += (x == m - 1 ? 1 : 0);
          x += (x < m - 1 ? 1 : 0);
        }
        up = !up;
      } else {
        x = new_row;
        y = new_column;
      }
    }
    return res;
  }
}
