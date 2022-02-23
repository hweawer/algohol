package edu.agus.leetcode.medium;

public class LongestSubarrayOf1AfterDeletingOneElement {
  public int longestSubarray(int[] nums) {
    int n = nums.length;
    if (n == 1) return 0;
    int[] forward = new int[n];
    int[] backward = new int[n];
    forward[0] = nums[0];
    backward[n - 1] = nums[n - 1];
    for (int i = 1; i < n; i++) {
      if (nums[i] == 0) forward[i] = 0;
      else forward[i] = forward[i - 1] + 1;
    }
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i] == 0) backward[i] = 0;
      else backward[i] = backward[i + 1] + 1;
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        res = Math.max(res, Math.max(forward[1], backward[1]));
      } else if (i == n - 1) {
        res = Math.max(res, Math.max(forward[n - 2], backward[n - 2]));
      } else {
        res = Math.max(res, forward[i - 1] + backward[i + 1]);
      }
    }
    return res;
  }
}
