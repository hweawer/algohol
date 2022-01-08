package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    Queue<Character> q = new LinkedList<>();
    Map<Character, Boolean> map = new HashMap<>();
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      if (!map.getOrDefault(s.charAt(i), false)) {
        map.put(s.charAt(i), true);
        q.add(s.charAt(i));
        if (q.size() > max) {
          max = q.size();
        }
      } else {
        while (map.getOrDefault(s.charAt(i), true)) {
          map.put(q.poll(), false);
        }
        q.add(s.charAt(i));
        map.put(s.charAt(i), true);
      }
    }
    return max;
  }
}
