package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarrayLen {
  public int maxSubArrayLen(int[] nums, int k) {
    int rollingSum = 0;
    int res = 0;
    Map<Integer, Integer> dict = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      rollingSum += nums[i];

      if (rollingSum == k) {
        res = Math.max(res, i + 1);
      }

      if (dict.containsKey(rollingSum - k)) {
        int el = dict.get(rollingSum - k);
        res = Math.max(res, i - el);
      }
      if (!dict.containsKey(rollingSum)) {
        dict.put(rollingSum, i);
      }
    }
    return res;
  }
}
