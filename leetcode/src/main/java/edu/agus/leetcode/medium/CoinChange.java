package edu.agus.leetcode.medium;

public class CoinChange {
  public int coinChange(int[] coins, int amount) {
    int[] mem = new int[amount + 1];
    for (int i = 1; i < amount + 1; i++) {
      mem[i] = Integer.MAX_VALUE;
    }
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          mem[i] = Math.min(mem[i], 1 + mem[i - coin]);
        }
      }
    }
    return mem[amount] == Integer.MAX_VALUE ? -1 : mem[amount];
  }
}
