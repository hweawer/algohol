package edu.agus.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget {
  public int maxNonOverlapping(int[] nums, int target) {
    Set<Integer> sums = new HashSet<>();
    sums.add(0);
    int rolling = 0;
    int res = 0;
    for (int i : nums) {
      rolling += i;
      if (sums.contains(rolling - target)) {
        res++;
        rolling = 0;
        sums = new HashSet<>();
      }
      sums.add(rolling);
    }
    return res;
  }
}
