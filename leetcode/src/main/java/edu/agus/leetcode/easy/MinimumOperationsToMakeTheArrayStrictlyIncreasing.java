package edu.agus.leetcode.easy;

public class MinimumOperationsToMakeTheArrayStrictlyIncreasing {
  public int minOperations(int[] nums) {
    int res = 0;
    if (nums.length == 1) return res;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] <= nums[i - 1]) {
        int diff = nums[i - 1] - nums[i] + 1;
        res += diff;
        nums[i] += diff;
      }
    }
    return res;
  }
}
