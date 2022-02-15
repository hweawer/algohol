package edu.agus.leetcode.medium;

public class ProductOfArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int[] forward = new int[nums.length];
    int[] backward = new int[nums.length];
    forward[0] = nums[0];
    backward[nums.length - 1] = nums[nums.length - 1];

    for (int i = 1; i < nums.length; i++) {
      forward[i] = forward[i - 1] * nums[i];
    }
    for (int j = nums.length - 2; j >= 0; j--) {
      backward[j] = backward[j + 1] * nums[j];
    }

    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        nums[i] = backward[1];
      } else if (i == nums.length - 1) {
        nums[i] = forward[nums.length - 2];
      } else {
        nums[i] = forward[i - 1] * backward[i + 1];
      }
    }
    return nums;
  }
}
