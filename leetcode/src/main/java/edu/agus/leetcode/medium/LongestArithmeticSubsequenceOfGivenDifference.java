package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {
  public int longestSubsequence(int[] arr, int difference) {
    Map<Integer, Integer> cache = new HashMap();
    int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int ans = 1;
    cache.put(arr[0], 1);
    for (int i = 1; i < arr.length; i++) {
      cache.put(arr[i], cache.getOrDefault(arr[i] - difference, 0) + 1);
      ans = Math.max(ans, cache.get(arr[i]));
    }
    return ans;
  }
}
