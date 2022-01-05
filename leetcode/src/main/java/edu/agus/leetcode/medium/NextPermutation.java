package edu.agus.leetcode.medium;

public class NextPermutation {
  public void reverse(int[] x, int l, int r) {
    while (l < r) {
      swap(x, l, r);
      l--;
      r++;
    }
  }

  public void swap(int[] x, int i, int j) {
    int temp = x[i];
    x[i] = x[j];
    x[j] = temp;
  }

  public void nextPermutation(int[] nums) {
    int i = nums.length - 2;
    int prev = nums[nums.length - 1];
    while (i >= 0) {
      if (prev > nums[i]) break;
      prev = nums[i];
      i--;
    }
    if (i == -1) {
      reverse(nums, 0, nums.length - 1);
      return;
    }
    int j = nums.length - 1;
    while (j > i && nums[i] >= nums[j]) {
      j--;
    }
    swap(nums, i, j);
    reverse(nums, i + 1, nums.length - 1);
  }
}
