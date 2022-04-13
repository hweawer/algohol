package edu.agus.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> dict = new HashMap();
    Set<Character> values = new HashSet();
    for (int i = 0; i < s.length(); i++) {
      if (dict.containsKey(s.charAt(i)) && !dict.get(s.charAt(i)).equals(t.charAt(i))) return false;
      if (!dict.containsKey(s.charAt(i)) && values.contains(t.charAt(i))) return false;
      dict.put(s.charAt(i), t.charAt(i));
      values.add(t.charAt(i));
    }
    return true;
  }
}
