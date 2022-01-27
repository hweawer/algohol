package edu.agus.leetcode.medium;

public class BestTimeToBuyAndSellStocks2 {
  public int maxProfit(int[] prices) {
    int max = prices[0];
    int min = prices[0];
    int res = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < max) {
        res += max - min;
        max = prices[i];
        min = prices[i];
      } else if (prices[i] > max) {
        max = prices[i];
      }
    }
    res += max - min;
    return res;
  }
}
