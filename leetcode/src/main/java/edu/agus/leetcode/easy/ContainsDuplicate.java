package edu.agus.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for(int x : nums) {
      if (set.contains(x)) return true;
      set.add(x);
    }
    return false;
  }
}
