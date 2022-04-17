package edu.agus.leetcode.medium;

import java.util.*;

public class MinimumCostToReachCityWithDiscounts {
  public int minimumCost(int n, int[][] highways, int discounts) {
    int[][] adj = new int[n][n];
    for (int[] row : adj) Arrays.fill(row, -1);
    for (int[] highway : highways) {
      int from = highway[0];
      int to = highway[1];
      int cost = highway[2];

      adj[from][to] = cost;
      adj[to][from] = cost;
    }
    Map<Integer, Integer> visited = new HashMap();
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(x -> x[1]));
    pq.add(new int[]{0, 0, discounts});
    while (!pq.isEmpty()) {
      int[] top = pq.poll();
      int v = top[0];
      int currentCost = top[1];
      int currentDiscount = top[2];
      if (top[2] < 0) continue;
      if (visited.containsKey(v) && currentDiscount <= visited.get(v)) continue;
      visited.put(v, currentDiscount);
      if (top[0] == n - 1) {
        return top[1];
      }
      for (int j = 0; j < n; j++) {
        if (adj[top[0]][j] != -1) {
          int[] en1 = {j, currentCost + adj[top[0]][j], currentDiscount};
          pq.add(en1);
          if (currentDiscount > 0) {
            int[] en2 = {j, currentCost + adj[top[0]][j] / 2, currentDiscount - 1};
            pq.add(en2);
          }
        }
      }
    }
    return -1;
  }
}
