package edu.agus.leetcode.medium;

import java.util.Random;

public class KthLargestElementInArray {
  Random rand = new Random();

  void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  int partition(int[] nums, int i, int left, int right) {
    swap(nums, i, right);
    int j = left;
    for (int idx = left; idx <= right - 1; idx++) {
      if (nums[idx] < nums[right]) {
        swap(nums, idx, j);
        j++;
      }
    }
    swap(nums, right, j);
    return j;
  }

  int quickSelect(int[] nums, int l, int r, int k) {
    int i = rand.nextInt(r - l + 1) + l;
    int pivot = partition(nums, i, l, r);
    if (pivot == k) return nums[pivot];
    else if (pivot < k) {
      return quickSelect(nums, pivot + 1, r, k);
    } else return quickSelect(nums, l, pivot - 1, k);
  }

  public int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, 0, nums.length - 1, nums.length - k);
  }
}
