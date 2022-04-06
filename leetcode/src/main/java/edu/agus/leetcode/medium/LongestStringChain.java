package edu.agus.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
  public int longestStrChain(String[] words) {
    Arrays.sort(words, Comparator.comparingInt(String::length));
    int res = 0;
    Map<String, Integer> map = new HashMap();
    for (String word : words) {
      StringBuilder sb = new StringBuilder(word);
      int max = 1;
      for (int j = 0; j < sb.length(); j++) {
        char c = sb.charAt(j);
        sb.deleteCharAt(j);
        String key = sb.toString();
        if (map.containsKey(key)) {
          max = Math.max(max, map.get(key) + 1);
        }
        sb.insert(j, c);
      }
      res = Math.max(res, max);
      map.put(word, max);
    }
    return res;
  }
}
