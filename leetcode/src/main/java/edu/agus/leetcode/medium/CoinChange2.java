package edu.agus.leetcode.medium;

public class CoinChange2 {
  public int change(int amount, int[] coins) {
    return change(amount, coins, 0, new Integer[coins.length][amount + 1]);
  }

  private int change(int amount, int[] coins, int start, Integer[][] dp) {
    if (amount == 0) {
      return 1;
    }

    if (amount < 0) {
      return 0;
    }

    if (dp[start][amount] != null) {
      return dp[start][amount];
    }

    int counts = 0;
    for (int i = start; i < coins.length; i++) {
      counts += change(amount - coins[i], coins, i, dp);
    }

    dp[start][amount] = counts;
    return counts;
  }
}
