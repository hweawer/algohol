package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// todo: idk why solutions to this task always involves sorting
public class MinimumDeletionsMakeCharacterFrequenciesUnique {
  public int minDeletions(String s) {
    Map<Character, Integer> dict = new HashMap<>();
    s.chars().forEach(c -> {
      char x = (char) c;
      if (dict.containsKey(x)) {
        dict.put(x, dict.get(x) + 1);
      } else {
        dict.put(x, 1);
      }
    });
    int res = 0;
    Set<Integer> set = new HashSet<>();
    for(Integer x : dict.values()) {
      while (set.contains(x) && x != 0) {
        x -= 1;
        res++;
      }
      set.add(x);
    }
    return res;
  }
}
