package edu.agus.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class CampusBikes2 {
  int smallest = Integer.MAX_VALUE;
  Set<Integer> visited = new HashSet();

  int getDistance(int[] worker, int[] bike) {
    return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
  }

  void backtracking(int[][] workers, int[][] bikes, int index, int curr) {
    if (index >= workers.length) {
      smallest = Math.min(smallest, curr);
      return;
    }
    if (curr >= smallest) return;

    for (int i = 0; i < bikes.length; i++) {
      if (!visited.contains(i)) {
        visited.add(i);
        backtracking(workers, bikes, index + 1, curr + getDistance(workers[index], bikes[i]));
        visited.remove(i);
      }
    }
  }

  public int assignBikes(int[][] workers, int[][] bikes) {
    backtracking(workers, bikes, 0, 0);
    return smallest;
  }
}
