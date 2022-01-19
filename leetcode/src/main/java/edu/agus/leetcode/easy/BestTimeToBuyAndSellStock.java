package edu.agus.leetcode.easy;

import java.util.PriorityQueue;
import java.util.Queue;

public class BestTimeToBuyAndSellStock {
  public static int maxProfit(int[] prices) {
    int profit = 0;
    int maxSell = prices[0], minBuy = prices[0];

    for (int x: prices) {
      if (x < minBuy) {
        minBuy = x;
        maxSell = x;
      }
      else if (x > maxSell) {
        maxSell = x;
      }
      profit = Math.max(maxSell - minBuy, profit);
    }
    return profit;
  }

  public static void main(String[] args) {
    maxProfit(new int[]{7, 1, 5, 3, 6, 4});
  }
}
