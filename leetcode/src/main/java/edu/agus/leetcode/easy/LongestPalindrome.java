package edu.agus.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
  Map<Character, Integer> map = new HashMap<>();

  public int longestPalindrome(String s) {
    int result = 0;
    boolean wasFound = false;
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    for (Integer i : map.values()) {
      if (i % 2 == 0) {
        result += i;
      } else {
        wasFound = true;
        result += i - 1;
      }
    }
    if (wasFound) result++;
    return result;
  }
}
