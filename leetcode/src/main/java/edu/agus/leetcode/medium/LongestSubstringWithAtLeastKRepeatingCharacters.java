package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
  public int longestSubstring(String s, int k) {
    if (s.length() < k) return 0;
    Map<Character, Integer> chars = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      int val = chars.getOrDefault(s.charAt(i), 0);
      chars.put(s.charAt(i), val + 1);
    }
    for (Map.Entry<Character, Integer> en : chars.entrySet()) {
      if (en.getValue() < k) {
        String[] strs = s.split(en.getKey().toString());
        int ans = 0;
        for (String str : strs) {
          ans = Math.max(ans, longestSubstring(str, k));
        }
        return ans;
      }
    }
    return s.length();
  }

}
