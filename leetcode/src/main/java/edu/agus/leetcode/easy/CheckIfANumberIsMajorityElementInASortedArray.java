package edu.agus.leetcode.easy;

public class CheckIfANumberIsMajorityElementInASortedArray {
  int findLeftBorder(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        if (mid == 0 || nums[mid - 1] < target) return mid;
      }
      if (nums[mid] < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return -1;
  }

  int findRightBorder(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        if (mid == nums.length - 1 || nums[mid + 1] > target) return mid;
      }
      if (nums[mid] > target) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return -1;
  }

  public boolean isMajorityElement(int[] nums, int target) {
    int leftBorder = findLeftBorder(nums, target);
    int rightBorder = findRightBorder(nums, target);
    if (leftBorder == -1 || rightBorder == -1) return false;
    int l = rightBorder - leftBorder + 1;
    return l > nums.length / 2.0;
  }
}
