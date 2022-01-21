package edu.agus.leetcode.easy;

public class MinCostClimbingStairs {
  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int[] mem = new int[n + 1];
    mem[0] = 0;
    mem[1] = 0;
    for (int i = 2; i <= n; i++) {
      mem[i] = Math.min(mem[i - 2] + cost[i - 2], mem[i - 1] + cost[i - 1]);
    }
    return mem[n];
  }
}
