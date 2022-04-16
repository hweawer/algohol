package edu.agus.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PathWithMinimumEffort {
  class Step implements Comparable<Step> {
    int priority;
    int x;
    int y;

    Step(int p, int x, int y) {
      this.priority = p;
      this.x = x;
      this.y = y;
    }

    public int compareTo(Step s) {
      return Integer.compare(this.priority, s.priority);
    }
  }

  Set<AsFarFromLandAsPossible.Pair> visited = new HashSet();

  public int minimumEffortPath(int[][] heights) {
    int m = heights.length;
    int n = heights[0].length;

    int[][] costs = new int[m][n];
    for (int[] row : costs) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }

    PriorityQueue<Step> pq = new PriorityQueue();
    pq.add(new Step(0, 0, 0));
    costs[0][0] = 0;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    while (!pq.isEmpty()) {
      Step top = pq.poll();
      visited.add(new AsFarFromLandAsPossible.Pair(top.x, top.y));
      for (int[] dir : dirs) {
        int x = top.x + dir[0];
        int y = top.y + dir[1];

        if (x < 0 || x >= m || y < 0 || y >= n || visited.contains(new AsFarFromLandAsPossible.Pair(x, y))) continue;
        int priority = Math.max(top.priority, Math.abs(heights[top.x][top.y] - heights[x][y]));
        if (priority < costs[x][y]) {
          costs[x][y] = priority;
          pq.add(new Step(priority, x, y));
        }
      }
    }
    return costs[m - 1][n - 1];
  }
}
