package edu.agus.leetcode.easy;

import java.util.Arrays;
import java.util.Map;

public class MaximizeSumAfterKNegotiations {
  public static int largestSumAfterKNegations(int[] nums, int k) {
    if (nums.length == 1) {
      if (k % 2 == 0) return nums[0];
      else return -nums[0];
    }
    Arrays.sort(nums);
    int i = 0;
    int result = 0;
    while (i < nums.length) {
      if (nums[i] == 0) {
        k = 0;
      } else if (nums[i] > 0 && k != 0) {
        nums[i] = k % 2 == 0 ? nums[i] : -nums[i];
        k = 0;
      } else if (nums[i] < 0 && k != 0) {
        if (i < nums.length - 1) {
          if (Math.abs(nums[i]) > Math.abs(nums[i + 1])) {
            nums[i] = -nums[i];
            k--;
          } else if (Math.abs(nums[i]) == Math.abs(nums[i + 1])) {
            if (nums[i] == nums[i + 1]) {
              nums[i] = -nums[i];
              k--;
            } else {
              nums[i] = k % 2 == 0 ? nums[i] : -nums[i];
              k = 0;
            }
          } else {
            nums[i] = k % 2 == 0 ? nums[i] : -nums[i];
            k = 0;
          }
        } else {
          nums[i] = k % 2 == 0 ? nums[i] : -nums[i];
          k = 0;
        }
      }
      result += nums[i];
      i++;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(largestSumAfterKNegations(new int[]{-2, 5, 0, 2, -2}, 3));
  }
}
