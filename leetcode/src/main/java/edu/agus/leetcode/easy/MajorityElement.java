package edu.agus.leetcode.easy;

public class MajorityElement {
  public int majorityElement(int[] nums) {
    int res = 0, count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[res]) count++;
      else count--;
      if (count == 0) {
        res = i;
        count = 1;
      }
    }
    return nums[res];
  }
}
