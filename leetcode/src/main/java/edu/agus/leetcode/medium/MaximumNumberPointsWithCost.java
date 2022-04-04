package edu.agus.leetcode.medium;

public class MaximumNumberPointsWithCost {
  public long maxPoints(int[][] points) {
    int m = points.length;
    int n = points[0].length;

    long[] dp = new long[n];
    for (int j = 0; j < n; j++) {
      dp[j] = points[0][j];
    }

    long[] left = new long[n];
    long[] right = new long[n];

    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (j == 0) {
          left[j] = dp[j];
        } else {
          left[j] = Math.max(left[j - 1] - 1, dp[j]);
        }
      }

      for (int j = n - 1; j >= 0; j--) {
        if (j == n - 1) {
          right[j] = dp[j];
        } else {
          right[j] = Math.max(right[j + 1] - 1, dp[j]);
        }
      }

      for (int j = 0; j < n; j++) {
        dp[j] = points[i][j] + Math.max(left[j], right[j]);
      }
    }

    long max = dp[0];
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
