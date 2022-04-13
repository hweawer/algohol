package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CounterOfBoomerangs {
  int distance(int[] a, int[] b) {
    return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
  }

  public int numberOfBoomerangs(int[][] points) {
    int count = 0;
    for (int[] point : points) {
      Map<Integer, Integer> counter = new HashMap();
      for (int[] ints : points) {
        int dist = distance(point, ints);
        int val = counter.getOrDefault(dist, 0) + 1;
        counter.put(dist, val);
      }

      for (int v : counter.values()) {
        count += v * (v - 1);
      }
    }
    return count;
  }
}
