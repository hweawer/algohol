package edu.agus.leetcode.easy;

import java.util.Arrays;

public class ArrayPartition {
  public int arrayPairSum(int[] nums) {
    int res = 0;
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i += 2) {
      res += Math.min(nums[i - 1], nums[i]);
    }
    return res;
  }
}
