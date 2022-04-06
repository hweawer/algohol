package edu.agus.leetcode.easy;

public class BestTimeToBuyAndSellStock {
  public static int maxProfit(int[] prices) {
    int minUpToI = prices[0];
    int result = 0;
    for (int price : prices) {
      result = Math.max(result, price - minUpToI);
      minUpToI = Math.min(price, minUpToI);
    }
    return result;
  }
}
