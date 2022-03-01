package edu.agus.leetcode.medium;

import java.util.*;

public class RepeatedDNASequence {
  public List<String> findRepeatedDnaSequences(String s) {
    Map<String, Integer> acc = new HashMap<>();
    if (s.length() <= 10) return new ArrayList<>();

    for (int left = 0, right = 10; right < s.length(); left++, right++) {
      String sub = s.substring(left, right);
      int val = acc.getOrDefault(sub, 0) + 1;
      acc.put(sub, val);
    }
    List<String> res = new ArrayList<>();
    for (Map.Entry<String, Integer> e : acc.entrySet()) {
      if (e.getValue() >= 2) res.add(e.getKey());
    }
    return res;
  }
}
