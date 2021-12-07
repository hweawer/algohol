package edu.agus.leetcode.medium;

public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int m = left + (right - left) / 2;
      if (target == nums[m]) return m;

      if (nums[left] <= nums[m]) {
        if (target > nums[m] || target < nums[left]) left = m + 1;
        else right = m - 1;
      } else {
        if (target < nums[m] || target > nums[right]) right = m - 1;
        else left = m + 1;
      }
    }
    return -1;
  }
}
