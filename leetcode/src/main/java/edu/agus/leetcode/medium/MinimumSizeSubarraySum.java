package edu.agus.leetcode.medium;

public class MinimumSizeSubarraySum {
  public int minSubArrayLen(int target, int[] nums) {
    int cur = Integer.MAX_VALUE;
    int acc = 0;
    for (int left = 0, right = 0; right < nums.length; right++) {
      acc += nums[right];
      while (left <= right && acc >= target) {
        cur = Math.min(cur, right - left + 1);
        acc -= nums[left++];
      }
    }
    return cur == Integer.MAX_VALUE ? 0 : cur;
  }
}
