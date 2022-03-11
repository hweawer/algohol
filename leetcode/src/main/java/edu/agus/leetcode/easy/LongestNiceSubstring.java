package edu.agus.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {
  public String longestNiceSubstring(String s) {
    if (s.length() < 2) return "";
    Set<Character> grammar = new HashSet<>();
    char[] chars = s.toCharArray();
    for (char c : chars) grammar.add(c);
    for (int i = 0; i < s.length(); i++) {
      if (grammar.contains(Character.toLowerCase(s.charAt(i))) && grammar.contains(Character.toUpperCase(s.charAt(i))))
        continue;
      String s1 = longestNiceSubstring(s.substring(0, i));
      String s2 = longestNiceSubstring(s.substring(i + 1));
      return s1.length() >= s2.length() ? s1 : s2;
    }
    return s;
  }
}
