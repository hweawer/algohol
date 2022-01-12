package edu.agus.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
  public static class Cell {
    int x;
    int y;

    public Cell(int i, int j) {
      x = i;
      y = j;
    }
  }

  public int orangesRotting(int[][] grid) {
    int minutes = 0;
    Queue<Cell> q = new ArrayDeque<>();
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) {
          q.add(new Cell(i, j));
        }
      }
    }

    while (!q.isEmpty()) {
      int size = q.size();
      minutes++;
      for (int i = 0; i < size; i++) {
        Cell cell = q.poll();
        if (cell.x > 0 && grid[cell.x - 1][cell.y] == 1) {
          grid[cell.x - 1][cell.y] = 2;
          q.add(new Cell(cell.x - 1, cell.y));
        }
        if (cell.x < m - 1 && grid[cell.x + 1][cell.y] == 1) {
          grid[cell.x + 1][cell.y] = 2;
          q.add(new Cell(cell.x + 1, cell.y));
        }
        if (cell.y > 0 && grid[cell.x][cell.y - 1] == 1) {
          grid[cell.x][cell.y - 1] = 2;
          q.add(new Cell(cell.x, cell.y - 1));
        }
        if (cell.y < n - 1 && grid[cell.x][cell.y + 1] == 1) {
          grid[cell.x][cell.y + 1] = 2;
          q.add(new Cell(cell.x, cell.y + 1));
        }
      }
    }
    for (int[] ints : grid) {
      for (int j = 0; j < n; j++) {
        if (ints[j] == 1) return -1;
      }
    }
    return minutes > 0 ? minutes - 1 : 0;
  }
}
