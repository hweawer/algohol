package edu.agus.leetcode.medium;

public class ArithmeticSlices {
  public static int numberOfArithmeticSlices(int[] nums) {
    int n = nums.length;
    int[] mem = new int[n];
    int count = 0;

    for (int i = 2; i < n; i++) {
      int diff = nums[i - 1] - nums[i - 2];
      if (diff == nums[i] - nums[i - 1]) {
        mem[i] = mem[i - 1] + 1;
        count += mem[i];
      }
    }
    return count;
  }
}
