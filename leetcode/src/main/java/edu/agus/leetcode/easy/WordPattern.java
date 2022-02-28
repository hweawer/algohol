package edu.agus.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
  public boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ");
    if (words.length != pattern.length()) return false;
    Map<Character, String> dict = new HashMap<>();

    for (int i = 0; i < pattern.length(); i++) {
      if (dict.containsKey(pattern.charAt(i))) {
        if (!dict.get(pattern.charAt(i)).equals(words[i])) return false;
      } else {
        if (dict.containsValue(words[i])) return false;
        dict.put(pattern.charAt(i), words[i]);
      }
    }
    return true;
  }
}
