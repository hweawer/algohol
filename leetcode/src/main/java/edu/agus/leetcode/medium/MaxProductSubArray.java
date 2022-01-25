package edu.agus.leetcode.medium;

public class MaxProductSubArray {
  public int maxProduct(int[] nums) {
    int current = 1;
    int max = Integer.MIN_VALUE;
    for (int n : nums) {
      current = Math.max(n, current * n);
      max = Math.max(max, current);
    }
    return max;
  }
}
