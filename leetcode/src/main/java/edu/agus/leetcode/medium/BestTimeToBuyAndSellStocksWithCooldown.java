package edu.agus.leetcode.medium;

public class BestTimeToBuyAndSellStocksWithCooldown {

  public int maxProfit(int[] prices) {
    int b = -prices[0];
    int s = 0;
    int c = 0;

    for (int i = 1; i < prices.length; i++) {
      b = Math.max(c - prices[i], b);
      c = Math.max(s, c);
      s = Math.max(b + prices[i], s);
    }
    return s;
  }
}
