package edu.agus.leetcode.easy;

public class MoveZeros {
  public void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public int findFirstNonZero(int initial, int[] arr) {
    while (initial < arr.length && arr[initial] == 0) {
      initial++;
    }
    return initial;
  }

  public void moveZeroes(int[] nums) {
    int firstNotZero = findFirstNonZero(0, nums);
    for (int i = 0; i < nums.length; i++) {
      if (firstNotZero >= nums.length) break;
      if (nums[i] == 0) {
        swap(nums, i, firstNotZero);
        firstNotZero = findFirstNonZero(i + 1, nums);
      }
    }
  }
}
