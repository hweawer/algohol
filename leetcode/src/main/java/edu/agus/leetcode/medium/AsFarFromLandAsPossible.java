package edu.agus.leetcode.medium;

import java.util.LinkedList;

public class AsFarFromLandAsPossible {
  static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  static class Pair {
    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static int maxDistance(int[][] matrix) {
    LinkedList<Pair> queue = new LinkedList<>();
    int m = matrix.length;
    int n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 1) {
          queue.addLast(new Pair(i, j));
        }
      }
    }
    if (queue.isEmpty()) {
      return -1;
    }
    if (queue.size() == n * m) {
      return -1;
    }
    int level = -1;
    while (!queue.isEmpty()) {
      level++;
      int size = queue.size();
      while (size > 0) {
        size--;
        Pair rem = queue.removeFirst();
        for (int i = 0; i < 4; i++) {
          int idash = rem.x + dirs[i][0];
          int jdash = rem.y + dirs[i][1];
          if (idash < 0 || idash >= m || jdash < 0 || jdash >= n || matrix[idash][jdash] == 1) {
            continue;
          }
          queue.addLast(new Pair(idash, jdash));
          matrix[idash][jdash] = 1;
        }
      }

    }
    return level;
  }
}
