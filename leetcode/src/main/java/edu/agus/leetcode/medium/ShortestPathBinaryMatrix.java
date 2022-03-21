package edu.agus.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
  static class Pair {
    int x;
    int y;

    Pair(int i, int j) {
      this.x = i;
      this.y = j;
    }
  }

  public int shortestPathBinaryMatrix(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) return -1;
    if (m == n && m == 1) return 0;
    int[][] dirs = new int[][]{
        {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(0, 0));
    int level = 0;
    while (!queue.isEmpty()) {
      level++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Pair node = queue.poll();
        for (int[] dir : dirs) {
          int x = node.x + dir[0];
          int y = node.y + dir[1];
          if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 0) continue;
          grid[x][y] = level;
          queue.add(new Pair(x, y));
        }
      }
    }
    return grid[m - 1][n - 1];
  }
}
