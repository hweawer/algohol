package edu.agus.leetcode.hard;

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {
  int m;
  int n;

  int dfs(int[][] matrix, int[][] mem, int i, int j, int prev) {
    if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] <= prev) return 0;

    if (mem[i][j] != Integer.MIN_VALUE) return mem[i][j];

    int top = dfs(matrix, mem, i - 1, j, matrix[i][j]);
    int right = dfs(matrix, mem, i, j + 1, matrix[i][j]);
    int bot = dfs(matrix, mem, i + 1, j, matrix[i][j]);
    int left = dfs(matrix, mem, i, j - 1, matrix[i][j]);

    mem[i][j] = Math.max(mem[i][j], Math.max(Math.max(top, right), Math.max(bot, left)) + 1);
    return mem[i][j];
  }

  public int longestIncreasingPath(int[][] matrix) {
    int result = 0;
    this.m = matrix.length;
    this.n = matrix[0].length;

    int[][] mem = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(mem[i], Integer.MIN_VALUE);
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result = Math.max(result, dfs(matrix, mem, i, j, Integer.MIN_VALUE));
      }
    }
    return result;
  }
}
