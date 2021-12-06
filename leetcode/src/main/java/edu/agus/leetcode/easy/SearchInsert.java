package edu.agus.leetcode.easy;

public class SearchInsert {
  public int binarySearch(int[] array, int x, int left, int right) {
    int res = -1;
    while (left <= right && res == -1) {
      int m = left + (right - left) / 2;
      if (array[m] == x) {
        res = m;
      } else if (x < array[m]) {
        right = m - 1;
      } else {
        left = m + 1;
      }
    }
    return res == -1 ? left : res;
  }

  public int searchInsert(int[] nums, int target) {
    return binarySearch(nums, target, 0, nums.length - 1);
  }
}
