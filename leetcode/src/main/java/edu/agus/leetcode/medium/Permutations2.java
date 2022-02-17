package edu.agus.leetcode.medium;

import java.util.*;

public class Permutations2 {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> perm = new ArrayList<>();
  Map<Integer, Integer> count = new HashMap<>();

  public void dfs(int n) {
    if (perm.size() == n) {
      res.add(new ArrayList<>(perm));
    } else {
      for (Integer key : count.keySet()) {
        if (count.get(key) > 0) {
          perm.add(key);
          int value = count.get(key) - 1;
          count.put(key, value);
          dfs(n);
          count.put(key, value + 1);
          perm.remove(perm.size() - 1);
        }
      }
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    for (int num : nums) {
      int val = count.getOrDefault(num, 0) + 1;
      count.put(num, val);
    }
    dfs(nums.length);
    return res;
  }
}
