package edu.agus.leetcode.medium;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
  public int findMinDifference(List<String> timePoints) {
    int[] times = new int[timePoints.size()];
    for (int i = 0; i < timePoints.size(); i++) {
      String[] t = timePoints.get(i).split(":");
      int hours = Integer.parseInt(t[0]) * 60;
      int minutes = Integer.parseInt(t[1]);
      times[i] = hours + minutes;
    }
    Arrays.sort(times);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < times.length; i++) {
      int diff;
      if (i == times.length - 1) {
        diff = times[times.length - 1] - times[0];
      } else diff = times[i + 1] - times[i];
      if (diff > 12 * 60) diff = 24 * 60 % diff;
      min = Math.min(min, diff);
    }
    return min;
  }
}
