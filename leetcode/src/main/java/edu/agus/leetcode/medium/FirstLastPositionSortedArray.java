package edu.agus.leetcode.medium;

public class FirstLastPositionSortedArray {
  public int binarySearch(int[] array, int x, int left, int right, boolean rightBorder) {
    int res = -1;
    while (left <= right) {
      int m = left + (right - left) / 2;
      if (array[m] == x) {
        res = m;
      }
      if (array[m] == x && rightBorder) {
        left = m + 1;
      } else if (array[m] == x && !rightBorder) {
        right = m - 1;
      } else if (x < array[m]) {
        right = m - 1;
      } else {
        left = m + 1;
      }
    }
    return res;
  }

  public int[] searchRange(int[] nums, int target) {
    int rightBorder = binarySearch(nums, target, 0, nums.length - 1, true);
    int leftBorder = rightBorder == -1 ? -1 : binarySearch(nums, target, 0, rightBorder, false);
    return new int[]{leftBorder, rightBorder};
  }
}
