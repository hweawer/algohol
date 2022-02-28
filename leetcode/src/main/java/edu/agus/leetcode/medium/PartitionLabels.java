package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
  public List<Integer> partitionLabels(String s) {
    List<Integer> res = new ArrayList<>();
    Map<Character, Integer> dict = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      dict.put(s.charAt(i), i);
    }
    int max = 0;
    int prev = -1;
    for (int i = 0; i < s.length(); i++) {
      max = Math.max(max, dict.get(s.charAt(i)));

      if (max == i) {
        res.add(max - prev);
        prev = i;
      }
    }
    return res;
  }
}
