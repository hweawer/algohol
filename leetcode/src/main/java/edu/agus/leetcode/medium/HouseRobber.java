package edu.agus.leetcode.medium;

public class HouseRobber {
  public int rob(int[] nums) {
    int[] mem = new int[nums.length + 2];
    for (int i = 0; i < nums.length; i++) {
      int memInd = i + 2;
      mem[memInd] = Math.max(mem[memInd - 1], nums[i] + mem[memInd - 2]);
    }
    return mem[mem.length - 1];
  }
}
