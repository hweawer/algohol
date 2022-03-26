package edu.agus.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
  void addToResult(List<String> ans, int l, int r) {
    if (l == r) ans.add(String.valueOf(l));
    else ans.add(l + "->" + r);
  }

  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> ans = new ArrayList<>();
    if (nums.length == 0) {
      addToResult(ans, lower, upper);
      return ans;
    }
    for (int n : nums) {
      if (n == lower) lower = n + 1;
      else if (lower < n) {
        addToResult(ans, lower, Math.min(n - 1, upper));
        lower = n + 1;
      }
    }
    if (upper > nums[nums.length - 1]) addToResult(ans, lower, upper);
    return ans;
  }
}
