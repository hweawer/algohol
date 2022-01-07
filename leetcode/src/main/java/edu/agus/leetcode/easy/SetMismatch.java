package edu.agus.leetcode.easy;

public class SetMismatch {
  public int[] findErrorNums(int[] nums) {
    int dup = -1, missing = 0;
    for (int x : nums) {
      if (nums[Math.abs(x) - 1] < 0) {
        dup = Math.abs(x);
      } else {
        nums[Math.abs(x) - 1] *= -1;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        missing = i + 1;
      }
    }
    return new int[]{dup, missing};
  }
}
