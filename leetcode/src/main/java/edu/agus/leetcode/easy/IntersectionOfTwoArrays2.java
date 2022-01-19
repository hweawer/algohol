package edu.agus.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class IntersectionOfTwoArrays2 {
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> counter = new HashMap<>();
    ArrayList<Integer> res = new ArrayList<>();
    for (int x : nums1) {
      if (!counter.containsKey(x)) {
        counter.put(x, 1);
      } else {
        counter.put(x, counter.get(x) + 1);
      }
    }

    for (int x: nums2) {
      if (counter.containsKey(x) && counter.get(x) > 0) {
        res.add(x);
        counter.put(x, counter.get(x) - 1);
      }
    }
    return res.stream().mapToInt(i -> i).toArray();
  }
}
