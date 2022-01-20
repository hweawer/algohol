package edu.agus.leetcode.easy;

public class ReshapeMatrix {
  public static int[][] matrixReshape(int[][] mat, int r, int c) {
    int m = mat.length;
    int n = mat[0].length;
    if (r * c > m * n) return mat;
    int ic = 0;
    int jc = 0;
    int[][] res = new int[r][c];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (ic == r) return res;
        res[ic][jc] = mat[i][j];
        if (jc == c - 1) {
          ic++;
          jc = 0;
        } else {
          jc++;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    matrixReshape(new int[][] {
        {1, 2},
        {3, 4}
    }, 1, 4);
  }
}
