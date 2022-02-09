package edu.agus.leetcode.medium;

import java.util.Arrays;

public class PerfectSquares {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, n);
    dp[0] = 0;
    for (int target = 1; target <= n; target++)
      for (int remaining = 1; remaining <= n; remaining++) {
        int square = remaining * remaining;
        if (target - square < 0)
          break;
        dp[target] = Math.min(dp[target], 1 + dp[target - square]);
      }
    return dp[n];
  }
}
