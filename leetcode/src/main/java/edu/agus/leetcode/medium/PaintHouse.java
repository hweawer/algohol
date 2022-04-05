package edu.agus.leetcode.medium;

public class PaintHouse {
  /*
    1. State
    minimum cost to paint all houses up to i if i is painted in j
    dp[i][j]
        red blue green
    1   17  2 17
    2
    3

    2. Formula
    dp[i][j] = min(dp[i-1][k]) + cost[i][j]  for k = 0 n k != j

    3. Base case is first line
    */
  public int minCost(int[][] costs) {
    int m = costs.length;
    int n = 3;

    for (int i = 1; i < m; i++) {
      costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
      costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
      costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
    }

    int min = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++) {
      min = Math.min(min, costs[m - 1][j]);
    }
    return min;
  }
}
