package edu.agus.leetcode.medium;

public class RotateArray {
  public void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public void reverse(int[] arr, int l, int r) {
    while (l <= r) {
      swap(arr, l, r);
      l++;
      r--;
    }
  }

  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    reverse(nums, 0, nums.length - 1 - k);
    reverse(nums, nums.length - k, nums.length - 1);
    reverse(nums, 0, nums.length - 1);
  }
}
