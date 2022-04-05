package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class DetectSquares {
  // x -> y -> count
  Map<Integer, Map<Integer, Integer>> dict = new HashMap();

  public DetectSquares() {

  }

  public void add(int[] point) {
    int x = point[0];
    int y = point[1];

    Map<Integer, Integer> yToFreq = dict.getOrDefault(x, new HashMap());
    int freq = yToFreq.getOrDefault(y, 0) + 1;
    yToFreq.put(y, freq);
    dict.put(x, yToFreq);
  }

  public int count(int[] point) {
    Map<Integer, Integer> pointsX = dict.get(point[0]);
    if (pointsX == null) return 0;
    int res = 0;
    for (Map.Entry<Integer, Integer> en : pointsX.entrySet()) {
      int y = en.getKey();
      if (y == point[1]) continue;
      int len = Math.abs(y - point[1]);
      Map<Integer, Integer> pointsX2 = dict.get(point[0] - len);
      Map<Integer, Integer> pointsX3 = dict.get(point[0] + len);
      if (pointsX2 == null && pointsX3 == null) continue;
      if (pointsX2 != null) {
        res += pointsX.get(y) * pointsX2.getOrDefault(y, 0) * pointsX2.getOrDefault(point[1], 0);
      }
      if (pointsX3 != null) {
        res += pointsX.get(y) * pointsX3.getOrDefault(y, 0) * pointsX3.getOrDefault(point[1], 0);
      }
    }
    return res;
  }
}
