package edu.agus.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
  public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, Comparator.comparingInt(x -> (x[0] - x[1])));
    int n = costs.length;
    int ans = 0;
    for (int i = 0; i < n / 2; i++) ans += costs[i][0];
    for (int i = n / 2; i < n; i++) ans += costs[i][1];
    return ans;
  }
}
