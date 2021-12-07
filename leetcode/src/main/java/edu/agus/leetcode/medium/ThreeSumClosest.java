package edu.agus.leetcode.medium;

import java.util.Arrays;

public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int abs = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1;
      int right = nums.length - 1;
      while (left != right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == target) return sum;
        else if (sum < target) left++;
        else right--;
        if (Math.abs(target - abs) > Math.abs(target - sum)) {
          abs = sum;
        }
      }
    }
    return abs;
  }
}
