package edu.agus.leetcode.medium;

public class JumpGame {
  public boolean canJump(int[] nums) {
    int indexToJump = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > indexToJump) return false;
      indexToJump = Math.max(nums[i] + i, indexToJump);
    }
    return true;
  }
}
