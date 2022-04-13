package edu.agus.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {
  public List<List<Integer>> largeGroupPositions(String s) {
    //abbxxxxzzy
    List<List<Integer>> result = new ArrayList();
    int left = 0;
    int right = 0;
    char c = s.charAt(0);
    while (left < s.length()) {
      while (right < s.length() && s.charAt(left) == s.charAt(right)) {
        right++;
      }
      if (right - left >= 3) {
        List<Integer> interval = new ArrayList();
        interval.add(left);
        interval.add(right - 1);
        result.add(interval);
      }
      left = right;
    }
    return result;
  }
}
