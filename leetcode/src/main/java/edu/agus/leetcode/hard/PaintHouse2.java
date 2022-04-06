package edu.agus.leetcode.hard;

public class PaintHouse2 {
  public int[] min(int[] row) {
    int firstMin = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    for (int i = 0; i < row.length; i++) {
      if (firstMin == Integer.MAX_VALUE) {
        firstMin = i;
      } else if (row[i] < row[firstMin]) {
        secondMin = firstMin;
        firstMin = i;
      } else if (secondMin == Integer.MAX_VALUE) {
        secondMin = i;
      } else {
        if (row[i] < row[secondMin]) {
          secondMin = i;
        }
      }
    }
    return new int[]{firstMin, secondMin};
  }

  public int minCostII(int[][] costs) {
    int m = costs.length;
    int n = costs[0].length;
    for (int i = 1; i < m; i++) {
      int[] mins = min(costs[i - 1]);
      for (int j = 0; j < n; j++) {
        if (j != mins[0]) {
          costs[i][j] += costs[i - 1][mins[0]];
        } else {
          costs[i][j] += costs[i - 1][mins[1]];
        }
      }
    }

    int min = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++) {
      min = Math.min(min, costs[m - 1][j]);
    }
    return min;
  }

  public static void main(String[] args) {
    PaintHouse2 ph = new PaintHouse2();
    ph.minCostII(new int[][]{
        {1, 5, 3}, {2, 9, 4}
    });
  }
}
