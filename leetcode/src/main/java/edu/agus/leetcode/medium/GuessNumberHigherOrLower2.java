package edu.agus.leetcode.medium;

import java.util.Arrays;

public class GuessNumberHigherOrLower2 {
  public int getMoneyAmount(int n) {
    int[][] mem = new int[n + 1][n + 1];
    for (int[] x : mem) {
      Arrays.fill(x, -1);
    }
    return dp(1, n, mem);
  }

  public int dp(int s, int e, int[][] mem) {
    if (s >= e) return 0;
    if (mem[s][e] != -1) return mem[s][e];
    int ans = Integer.MAX_VALUE;
    for (int i = s; i <= e; i++) {
      ans = Math.min(ans, i + Math.max(dp(s, i - 1, mem), dp(i + 1, e, mem)));
    }
    return mem[s][e] = ans;
  }
}
