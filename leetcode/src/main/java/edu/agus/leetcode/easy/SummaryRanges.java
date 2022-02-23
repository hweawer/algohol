package edu.agus.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    List<String> res = new ArrayList<>();
    int r = nums[0];
    int l = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - 1 == r) {
        r = nums[i];
      } else {
        res.add(interval(l, r));
        l = nums[i];
        r = nums[i];
      }
    }
    res.add(interval(l, r));
    return res;
  }

  public String interval(int l, int r) {
    if (l == r) return String.valueOf(l);
    else return l + "->" + r;
  }
}
