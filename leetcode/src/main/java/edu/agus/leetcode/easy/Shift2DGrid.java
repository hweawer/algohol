package edu.agus.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
  public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] result = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int col = (j + k) % n;
        int row = (i + (j + k) / n) % m;
        result[row][col] = grid[i][j];
      }
    }
    List<List<Integer>> res = new ArrayList();
    for (int i = 0; i < m; i++) res.add(new ArrayList());
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        res.get(i).add(result[i][j]);
      }
    }
    return res;
  }
}
