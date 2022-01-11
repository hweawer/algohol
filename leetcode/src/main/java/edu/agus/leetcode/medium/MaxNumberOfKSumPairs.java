package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {
  public int maxOperations(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], 1);
      } else {
        map.put(nums[i], map.get(nums[i]) + 1);
      }
    }
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      if (map.get(nums[i]) > 0) {
        int reduct = k - nums[i];
        if (map.containsKey(reduct) && map.get(reduct) >= 1) {
          if (reduct == nums[i]) {
            if (map.get(reduct) >= 2) {
              res++;
              map.put(reduct, map.get(reduct) - 2);
            }
          } else {
            res++;
            map.put(reduct, map.get(reduct) - 1);
            map.put(nums[i], map.get(nums[i]) - 1);
          }
        }
      }
    }
    return res;
  }
}
