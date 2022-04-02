package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Sum42 {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    int cnt = 0;
    Map<Integer, Integer> m = new HashMap<>();
    for (int a : A) {
      for (int b : B) {
        m.put(a + b, m.getOrDefault(a + b, 0) + 1);
      }
    }
    for (int c : C) {
      for (int d : D) {
        cnt += m.getOrDefault(-(c + d), 0);
      }
    }
    return cnt;
  }
}
