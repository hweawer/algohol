package edu.agus.leetcode.medium;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
  int[][] dp;

  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int n : nums) sum += n;
    if (sum % 2 == 1) return false;
    int target = sum / 2;
    dp = new int[nums.length][target + 1];
    for (int[] row : dp) Arrays.fill(row, -1);
    return rec(nums, nums.length - 1, target);
  }

  public boolean rec(int[] nums, int bottom, int target) {
    if (target == 0) return true;
    if (bottom == 0) return nums[bottom] == target;

    if (dp[bottom][target] != -1) {
      return dp[bottom][target] == 1;
    }
    boolean leave = rec(nums, bottom - 1, target);
    boolean take = false;
    if (nums[bottom] <= target) {
      take = rec(nums, bottom - 1, target - nums[bottom]);
    }
    boolean result = leave || take;
    dp[bottom][target] = result ? 1 : 0;
    return result;
  }
}
