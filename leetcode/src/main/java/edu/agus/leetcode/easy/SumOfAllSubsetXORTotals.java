package edu.agus.leetcode.easy;

public class SumOfAllSubsetXORTotals {
  public int subsetXORSum(int[] nums) {
    return backtrack(nums, 0, 0);
  }

  private int backtrack(int[] nums, int i, int xor) {
    return (i == nums.length) ? xor : backtrack(nums, i + 1, xor ^ nums[i]) + backtrack(nums, i + 1, xor);
  }
}
