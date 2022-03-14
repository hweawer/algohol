package edu.agus.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class FinalPricesWithASpecialDiscountInAShop {
  public int[] finalPrices(int[] prices) {
    Deque<Integer> stack = new ArrayDeque<>();
    int n = prices.length;
    int[] res = new int[n];
    stack.push(prices[n - 1]);
    res[n - 1] = prices[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() >= prices[i]) stack.poll();
      res[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
      stack.push(prices[i]);
    }
    return res;
  }
}
