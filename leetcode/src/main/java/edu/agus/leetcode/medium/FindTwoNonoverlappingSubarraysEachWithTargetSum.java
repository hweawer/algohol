package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class FindTwoNonoverlappingSubarraysEachWithTargetSum {
  public int minSumOfLengths(int[] arr, int target) {
    int n = arr.length, sum = 0, res = n + 1;
    Map<Integer, Integer> dict = new HashMap<>();
    dict.put(0, -1);
    int[] min = new int[n];
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      min[i] = i > 0 ? min[i - 1] : n + 1;
      if (dict.containsKey(sum - target)) {
        int k = dict.get(sum - target);
        int len = i - k;
        min[i] = Math.min(min[i], len);

        if (k != -1 && min[k] != n + 1) res = Math.min(res, min[k] + len);
      }
      dict.put(sum, i);
    }
    return res == n + 1 ? -1 : res;
  }
}
