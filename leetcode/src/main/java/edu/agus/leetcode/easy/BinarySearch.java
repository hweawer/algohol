package edu.agus.leetcode.easy;

public class BinarySearch {
  public int search(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    int m;
    while (l < r) {
      m = (l + r) / 2;
      if (nums[m] == target) return m;
      else if (target < nums[m]) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return -1;
  }
}
