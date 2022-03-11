package edu.agus.leetcode.easy;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestLowestOfKScores {
  public int minimumDifference(int[] nums, int k) {
    Arrays.sort(nums);
    int res = Integer.MAX_VALUE;
    for (int left = 0, right = k - 1; right < nums.length; left++, right++) {
      res = Math.min(res, nums[right] - nums[left]);
    }
    return res;
  }
}
