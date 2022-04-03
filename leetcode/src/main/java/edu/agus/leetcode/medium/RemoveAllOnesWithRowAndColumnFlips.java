package edu.agus.leetcode.medium;

public class RemoveAllOnesWithRowAndColumnFlips {
  public boolean removeOnes(int[][] grid) {
    for (int i = 1; i < grid.length; i++) {
      boolean same = true;
      boolean opposite = true;
      for (int j = 0; j < grid[0].length; j++) {
        same = same && grid[0][j] == grid[i][j];
        opposite = opposite && grid[0][j] != grid[i][j];
      }
      if (!same && !opposite) {
        return false;
      }
    }
    return true;
  }
}
