package edu.agus.leetcode.easy;

public class MaximumAverageSubarray {
  public static double findMaxAverage(int[] nums, int k) {
    double max = 0;
    for (int i = 0; i < k; i++) {
      max += nums[i];
    }
    max /= k;
    double prev = max;

    for (int left = 1, right = k; right < nums.length; left++, right++) {
      double avg = prev - ((double) nums[left - 1] / k) + ((double) nums[right] / k);
      max = Math.max(max, avg);
      prev = avg;
    }
    return max;
  }

  public static void main(String[] args) {
    findMaxAverage(new int[]{0,4,0,3,2}, 1);
  }
}
