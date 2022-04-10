package edu.agus.leetcode.medium;

import java.util.HashSet;

public class MininumAreaRectangle {

  class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public int minAreaRect(int[][] points) {
    HashSet<Pair> memo = new HashSet<>();
    for (int[] point : points) {
      memo.add(new Pair(point[0], point[1]));
    }
    int result = Integer.MAX_VALUE;
    for (int[] point : points) {
      for (int[] angPoint : points) {
        if (!(angPoint[0] == point[0] || point[1] == angPoint[1])) {
          if (memo.contains(new Pair(point[0], angPoint[1])) && memo.contains(new Pair(angPoint[0], point[1]))) {
            int width = Math.abs(point[0] - angPoint[0]);
            int height = Math.abs(point[1] - angPoint[1]);
            result = Math.min(result, width * height);
          }
        }
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }
}
