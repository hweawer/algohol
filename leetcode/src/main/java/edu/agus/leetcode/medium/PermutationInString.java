package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PermutationInString {
  public boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> dict = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      if (!dict.containsKey(s1.charAt(i))) {
        dict.put(s1.charAt(i), 1);
      } else {
        dict.put(s1.charAt(i), dict.get(s1.charAt(i)) + 1);
      }
    }
    Queue<Character> q = new LinkedList<>();
    Map<Character, Integer> cur = new HashMap<>();
    for (int i = 0; i < s2.length(); i++) {
      if (dict.containsKey(s2.charAt(i))) {
        int charNum = cur.getOrDefault(s2.charAt(i), 0);
        if (charNum < dict.get(s2.charAt(i))) {
          cur.put(s2.charAt(i), charNum + 1);
        } else {
          while (cur.get(s2.charAt(i)) >= dict.get(s2.charAt(i))) {
            Character e = q.poll();
            cur.put(e, cur.get(e) - 1);
          }
          cur.put(s2.charAt(i), cur.get(s2.charAt(i)) + 1);
        }
        q.add(s2.charAt(i));
        if (q.size() == s1.length()) return true;
      } else {
        q.clear();
        cur.clear();
      }
    }
    return false;
  }
}
