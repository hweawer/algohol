package edu.agus.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
  public int maximumUniqueSubarray(int[] nums) {
    int res = 0;
    int acc = 0;
    Set<Integer> set = new HashSet<>();
    for (int left = 0, right = 0; right < nums.length; right++) {
      while (set.contains(nums[right])) {
        set.remove(nums[left]);
        acc -= nums[left];
        left++;
      }
      set.add(nums[right]);
      acc += nums[right];
      res = Math.max(res, acc);
    }
    return res;
  }
}
