package edu.agus.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumNumberOfVisiblePoints {
  double degree(int originX, int originY, int x, int y) {
    return Math.toDegrees(Math.atan2(y - originY, x - originX));
  }

  public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
    List<Double> degrees = new ArrayList();
    int x = location.get(0);
    int y = location.get(1);
    int same = 0;
    for (List<Integer> point : points) {
      if (point.get(0) == x && point.get(1) == y) {
        same++;
        continue;
      }
      degrees.add(degree(x, y, point.get(0), point.get(1)));
    }
    Collections.sort(degrees);
    int size = degrees.size();
    for (int i = 0; i < size; i++) {
      degrees.add(360 + degrees.get(i));
    }
    int max = 0;
    for (int left = 0, right = 0; right < degrees.size(); right++) {
      while (Math.abs(degrees.get(right) - degrees.get(left)) > angle) {
        left++;
      }
      max = Math.max(max, right - left + 1);
    }
    return same + max;
  }
}
