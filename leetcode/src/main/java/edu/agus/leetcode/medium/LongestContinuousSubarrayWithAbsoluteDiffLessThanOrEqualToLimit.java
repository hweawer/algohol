package edu.agus.leetcode.medium;

import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
  public int longestSubarray(int[] nums, int limit) {
    PriorityQueue<Integer> max = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
    PriorityQueue<Integer> min = new PriorityQueue<>(Integer::compare);
    int res = 0;
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
      max.add(nums[right]);
      min.add(nums[right]);
      int diff = max.peek() - min.peek();
      while (diff > limit && left <= right) {
        max.remove(nums[left]);
        min.remove(nums[left]);
        left++;
        diff = max.peek() - min.peek();
      }
      res = Math.max(res, right - left + 1);
    }
    return res;
  }

  public static void main(String[] args) {
    LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit s = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();
    s.longestSubarray(new int[]{
        8, 2, 4, 7
    }, 4);
  }
}
