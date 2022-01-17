package edu.agus.leetcode.easy;

public class MaximumSubarray {
  public int maxSubArray(int[] nums) {
    int prevSum = 0;
    int maxSum = 0;
    int maxElem = nums[0];

    for (int x : nums) {
      prevSum += x;
      if (prevSum < 0) prevSum = 0;
      if (maxSum < prevSum) maxSum = prevSum;
      if (x > maxElem) maxElem = x;
    }
    return maxSum == 0 ? maxElem : maxSum;
  }
}
