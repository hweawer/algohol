package edu.agus.leetcode.easy;

public class MaximumSubarray {
  public int maxSubArray(int[] nums) {
    int currentSubarray = nums[0];
    int maxSubarray = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      currentSubarray = Math.max(num, currentSubarray + num);
      maxSubarray = Math.max(maxSubarray, currentSubarray);
    }

    return maxSubarray;
  }
}
