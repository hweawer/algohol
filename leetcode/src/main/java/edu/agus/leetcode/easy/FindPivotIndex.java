package edu.agus.leetcode.easy;

public class FindPivotIndex {
  public int pivotIndex(int[] nums) {
    int[] forward = new int[nums.length + 2];
    int[] backward = new int[nums.length + 2];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      forward[i + 1] = sum;
    }
    sum = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      sum += nums[i];
      backward[i + 1] = sum;
    }
    for (int i = 1; i < forward.length - 1; i++) {
      if (forward[i - 1] == backward[i + 1]) return i - 1;
    }
    return -1;
  }
}
