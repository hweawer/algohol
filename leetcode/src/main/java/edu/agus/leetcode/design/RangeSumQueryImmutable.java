package edu.agus.leetcode.design;

public class RangeSumQueryImmutable {
  class NumArray {
    int[] prefix;

    public NumArray(int[] nums) {
      int n = nums.length;
      prefix = new int[n];
      int sum = 0;
      for (int i = 0; i < n; i++) {
        sum += nums[i];
        prefix[i] = sum;
      }
    }

    public int sumRange(int left, int right) {
      if (left == 0) return prefix[right];
      else return prefix[right] - prefix[left - 1];
    }
  }

}
