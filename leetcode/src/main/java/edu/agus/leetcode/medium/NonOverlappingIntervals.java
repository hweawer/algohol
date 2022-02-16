package edu.agus.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
  public int eraseOverlapIntervals(int[][] intervals) {
    int n = intervals.length;
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

    int res = 0;
    int[] currentInterval = intervals[0];
    for (int i = 1; i < n; i++) {
      if (currentInterval[1] > intervals[i][0]) {
        currentInterval[1] = Math.min(currentInterval[1], intervals[i][1]);
        res++;
      } else currentInterval = intervals[i];
    }
    return res;
  }
}
