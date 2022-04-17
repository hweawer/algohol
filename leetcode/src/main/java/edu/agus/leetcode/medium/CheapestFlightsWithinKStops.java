package edu.agus.leetcode.medium;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    int[] prices = new int[n];
    Arrays.fill(prices, Integer.MAX_VALUE);
    prices[src] = 0;

    for (int i = 0; i < k + 1; i++) {
      int[] temp = Arrays.copyOf(prices, prices.length);
      for (int[] flight : flights) {
        int from = flight[0];
        int to = flight[1];
        int price = flight[2];

        if (prices[from] == Integer.MAX_VALUE) continue;

        temp[to] = Math.min(temp[to], prices[from] + price);
      }
      prices = temp;
    }
    return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
  }
}
