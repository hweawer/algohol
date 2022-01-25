package edu.agus.leetcode.medium;

public class MaximumLengthSubarrayWithPositiveProduct {
  public int getMaxLen(int[] nums) {
    int min = 0;
    int max = 0;
    int res = 0;
    for (int n : nums) {
      if (n == 0) {
        min = 0;
        max = 0;
      }
      else {
        if (min > 0) min++;
        max++;
        if (n < 0) {
          int t = max;
          max = min;
          min = t;
        }
        res = Math.max(res, max);
      }
    }
    return res;
  }
}
