package edu.agus.leetcode.medium;

public class LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    int n = nums.length;
    int[] mem = new int[n];
    mem[n - 1] = 1;
    int max = 1;
    for (int i = n - 2; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        if (nums[i] < nums[j]) {
          mem[i] = Math.max(mem[i], mem[j] + 1);
        } else {
          mem[i] = Math.max(mem[i], 1);
        }
        max = Math.max(max, mem[i]);
      }
    }
    return max;
  }
}
