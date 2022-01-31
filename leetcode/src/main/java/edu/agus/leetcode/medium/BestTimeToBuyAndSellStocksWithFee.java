package edu.agus.leetcode.medium;

public class BestTimeToBuyAndSellStocksWithFee {
  public int maxProfit(int[] prices, int fee) {
    int res = 0;
    int min = prices[0];

    for (int i = 1; i < prices.length; i++) {
      res = Math.max(res, prices[i] - min - fee);
      min = Math.min(min, prices[i] - res);
    }
    return res;
  }
}
