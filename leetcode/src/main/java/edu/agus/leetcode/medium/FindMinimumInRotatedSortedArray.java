package edu.agus.leetcode.medium;

public class FindMinimumInRotatedSortedArray {
  int binarySearch(int[] nums, int left, int right) {
    if (nums[left] <= nums[right]) return nums[left];
    int mid = left + right / 2;
    if (nums[mid] > nums[right]) return binarySearch(nums, mid + 1, right);
    return binarySearch(nums, left, mid);
  }

  public int findMin(int[] nums) {
    return binarySearch(nums, 0, nums.length - 1);
  }
}
