package edu.agus.leetcode.medium;

import java.util.Arrays;

public class TargetSum {
  int total;

  int dfs(int[][] dp, int idx, int rollingSum, int target, int[] nums) {
    if (idx == nums.length) {
      if (rollingSum == target) return 1;
      return 0;
    }
    if (dp[idx][rollingSum + total] != Integer.MIN_VALUE) {
      return dp[idx][rollingSum + total];
    }
    dp[idx][rollingSum + total] = dfs(dp, idx + 1, rollingSum + nums[idx], target, nums) + dfs(dp, idx + 1, rollingSum - nums[idx], target, nums);
    return dp[idx][rollingSum + total];
  }

  public int findTargetSumWays(int[] nums, int target) {
    for (int n : nums) total += n;
    int[][] dp = new int[nums.length][total * 2 + 1];
    for (int[] row : dp) {
      Arrays.fill(row, Integer.MIN_VALUE);
    }
    return dfs(dp, 0, 0, target, nums);
  }
}
