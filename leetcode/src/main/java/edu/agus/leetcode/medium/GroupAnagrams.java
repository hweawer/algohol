package edu.agus.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> res = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      if (!res.containsKey(key)) {
        List<String> v = new ArrayList<>();
        v.add(str);
        res.put(key, v);
      } else res.get(key).add(str);
    }
    return new ArrayList<>(res.values());
  }
}
