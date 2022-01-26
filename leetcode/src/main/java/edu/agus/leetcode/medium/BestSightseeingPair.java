package edu.agus.leetcode.medium;

public class BestSightseeingPair {
  public int maxScoreSightseeingPair(int[] values) {
    int first = values[0];
    int max = values[1] + first - 1;
    for (int i = 2; i < values.length; i++) {
      first = Math.max(first, values[i - 1] + i - 1);
      max = Math.max(max, first + values[i] - i);
    }
    return max;
  }
}
