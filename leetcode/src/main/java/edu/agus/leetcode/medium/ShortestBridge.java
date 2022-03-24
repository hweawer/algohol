package edu.agus.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
  void color(int[][] grid, int i, int j, int m, int n) {
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return;
    grid[i][j] = -1;
    color(grid, i - 1, j, m, n);
    color(grid, i, j + 1, m, n);
    color(grid, i + 1, j, m, n);
    color(grid, i, j - 1, m, n);
  }

  int bfs(int[][] grid, int m, int n) {
    Queue<int[]> points = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == -1) points.add(new int[]{i, j});
      }
    }
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int level = 0;
    while (!points.isEmpty()) {
      int size = points.size();
      for (int k = 0; k < size; k++) {
        int[] point = points.poll();
        for (int i = 0; i < 4; i++) {
          int x = point[0] + dirs[i][0];
          int y = point[1] + dirs[i][1];
          if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == -1) continue;
          if (grid[x][y] == 1) return level;
          grid[x][y] = -1;
          points.add(new int[]{x, y});
        }
      }
      level++;
    }
    return level;
  }

  public int shortestBridge(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean colored = false;
    for (int i = 0; i < m; i++) {
      if (!colored) {
        for (int j = 0; j < n; j++) {
          if (colored) break;
          if (grid[i][j] == 1) {
            color(grid, i, j, m, n);
            colored = true;
          }
        }
      } else break;
    }
    return bfs(grid, m, n);
  }
}
