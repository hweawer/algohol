package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> mem = new HashMap<>();
    mem.put(0, 1);
    int total = 0;
    int res = 0;
    for (int n : nums) {
      total += n;
      if (mem.containsKey(total - k)) {
        res += mem.get(total - k);
      }
      int val = mem.getOrDefault(total, 0) + 1;
      mem.put(total, val);
    }
    return res;
  }
}
