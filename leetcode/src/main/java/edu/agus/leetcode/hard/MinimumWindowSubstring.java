package edu.agus.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
  public boolean cmp(Map<Character, Integer> targetFreq, Map<Character, Integer> windowFreq) {
    for (Map.Entry<Character, Integer> en : targetFreq.entrySet()) {
      int window = windowFreq.getOrDefault(en.getKey(), 0);
      if (window < en.getValue()) return false;
    }
    return true;
  }

  public String minWindow(String s, String t) {
    Map<Character, Integer> targetFreq = new HashMap();
    for (char c : t.toCharArray()) {
      int freq = targetFreq.getOrDefault(c, 0) + 1;
      targetFreq.put(c, freq);
    }
    int right = 0;
    int left = 0;
    Map<Character, Integer> windowFreq = new HashMap();
    windowFreq.put(s.charAt(0), 1);
    String ans = "";
    while (right < s.length()) {
      while (left <= right && cmp(targetFreq, windowFreq)) {
        if (ans.isEmpty()) ans = s.substring(left, right + 1);
        else ans = (right + 1 - left) < ans.length() ? s.substring(left, right + 1) : ans;

        int f = windowFreq.get(s.charAt(left)) - 1;
        windowFreq.put(s.charAt(left), f);
        left++;
      }
      right++;
      if (right == s.length()) break;
      int fr = windowFreq.getOrDefault(s.charAt(right), 0) + 1;
      windowFreq.put(s.charAt(right), fr);
    }
    return ans;
  }
}
