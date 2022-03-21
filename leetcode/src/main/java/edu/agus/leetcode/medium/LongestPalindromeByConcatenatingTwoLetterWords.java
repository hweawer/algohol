package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeByConcatenatingTwoLetterWords {
  public int longestPalindrome(String[] words) {
    Map<String, Integer> map = new HashMap<>();
    for (String s : words) map.put(s, map.getOrDefault(s, 0) + 1);
    int out = 0;
    for (String s : words) {
      if (s.charAt(1) == s.charAt(0)) {
        if (map.containsKey(s) && map.get(s) > 1) {
          out += (map.get(s) / 2) * 4;
          if (map.get(s) % 2 == 0) map.remove(s);
          else map.put(s, 1);
        }
      } else {
        String reversed = s.charAt(1) + "" + s.charAt(0);
        if (map.containsKey(s) && map.containsKey(reversed)) {
          int v1 = map.get(s), v2 = map.get(reversed);
          out += Math.min(v1, v2) * 4;
        }
        map.remove(s);
      }
    }
    if (map.size() != 0) out += 2;
    return out;
  }
}
