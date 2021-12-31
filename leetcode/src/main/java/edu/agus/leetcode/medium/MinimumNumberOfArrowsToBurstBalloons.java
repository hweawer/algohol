package edu.agus.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
  public int findMinArrowShots(int[][] points) {
    if (points.length == 0) return 0;
    Arrays.sort(points, Comparator.comparingInt(x -> x[1]));
    int result = 1;
    int lastIncluded = points[0][1];
    for (int i = 1; i < points.length; i++) {
      boolean inInterval = points[i][0] <= lastIncluded && points[i][1] >= lastIncluded;
      if (!inInterval) {
        result++;
        lastIncluded = points[i][1];
      }
    }
    return result;
  }
}
