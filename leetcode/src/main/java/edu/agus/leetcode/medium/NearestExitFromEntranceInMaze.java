package edu.agus.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
  public int nearestExit(char[][] maze, int[] entrance) {
    int m = maze.length;
    int n = maze[0].length;
    int[][] dirs = new int[][]{
        {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    Queue<int[]> queue = new LinkedList<>();
    queue.add(entrance);
    maze[entrance[0]][entrance[1]] = '-';
    int level = 0;
    while (!queue.isEmpty()) {
      level++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] front = queue.poll();
        for (int j = 0; j < 4; j++) {
          int x = front[0] + dirs[j][0];
          int y = front[1] + dirs[j][1];
          if (x < 0 || x >= m || y < 0 || y >= n || maze[x][y] != '.') continue;
          if (x == 0 || y == 0 || x == m - 1 || y == n - 1) return level;
          maze[x][y] = '-';
          queue.add(new int[]{x, y});
        }
      }
    }
    return -1;
  }
}
