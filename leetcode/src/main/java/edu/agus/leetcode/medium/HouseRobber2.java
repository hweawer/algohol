package edu.agus.leetcode.medium;

public class HouseRobber2 {

  public int rob(int[] nums, int l, int r) {
    int size = r - l;
    int[] mem = new int[size + 2];
    int memInd = 2;
    for (int i = l; i < r; i++) {
      mem[memInd] = Math.max(mem[memInd - 1], mem[memInd - 2] + nums[i]);
      memInd++;
    }
    return mem[size + 1];
  }


  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
  }
}
