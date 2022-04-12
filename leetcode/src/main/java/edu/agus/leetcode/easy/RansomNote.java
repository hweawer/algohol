package edu.agus.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RansomNote {
  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> dict = new HashMap<>();
    for (int i = 0; i < magazine.length(); i++) {
      int v = dict.getOrDefault(magazine.charAt(i), 0) + 1;
      dict.put(magazine.charAt(i), v);
    }

    for (int i = 0; i < ransomNote.length(); i++) {
      char c = ransomNote.charAt(i);
      if (!dict.containsKey(c)) return false;
      int v = dict.get(c) - 1;
      if (v < 0) return false;
      dict.put(c, v);
    }
    return true;
  }
}
