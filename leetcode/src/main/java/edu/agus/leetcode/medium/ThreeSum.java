package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    if (nums.length == 0 || nums[0] > 0) return result;
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) continue;
      else {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
          int sum = nums[i] + nums[left] + nums[right];
          if (sum > 0) right--;
          else if (sum < 0) left++;
          else {
            List<Integer> triple = new ArrayList<>();
            triple.add(nums[i]);
            triple.add(nums[left]);
            triple.add(nums[right]);
            result.add(triple);
            left++;
            while (nums[left] == nums[left - 1] && left < right) {
              left++;
            }
          }
        }
      }
    }
    return result;
  }
}
