package edu.agus.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class Matrix01 {
  public static class Cell {
    int x;
    int y;
    int distance;

    public Cell(int i, int j, int distance) {
      this.x = i;
      this.y = j;
      this.distance = distance;
    }
  }

  public int[][] updateMatrix(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    Queue<Cell> q = new ArrayDeque<>();
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 0) {
          visited[i][j] = true;
          q.add(new Cell(i, j, 0));
        }
      }
    }
    while (!q.isEmpty()) {
      Cell first = q.poll();
      mat[first.x][first.y] = first.distance;
      if (first.x > 0 && !visited[first.x - 1][first.y]) {
        int distance = mat[first.x - 1][first.y] == 0 ? 0 : first.distance + 1;
        q.add(new Cell(first.x - 1, first.y, distance));
        visited[first.x - 1][first.y] = true;
      }
      if (first.x < m - 1 && !visited[first.x + 1][first.y]) {
        int distance = mat[first.x + 1][first.y] == 0 ? 0 : first.distance + 1;
        q.add(new Cell(first.x + 1, first.y, distance));
        visited[first.x + 1][first.y] = true;
      }
      if (first.y > 0 && !visited[first.x][first.y - 1]) {
        int distance = mat[first.x][first.y - 1] == 0 ? 0 : first.distance + 1;
        q.add(new Cell(first.x, first.y - 1, distance));
        visited[first.x][first.y - 1] = true;
      }
      if (first.y < n - 1 && !visited[first.x][first.y + 1]) {
        int distance = mat[first.x][first.y + 1] == 0 ? 0 : first.distance + 1;
        q.add(new Cell(first.x, first.y + 1, distance));
        visited[first.x][first.y + 1] = true;
      }
    }
    return mat;
  }
}
