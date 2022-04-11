package edu.agus.leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
  class BFSStep {
    int x;
    int y;
    int[][] state;

    BFSStep(int x, int y, int[][] state) {
      this.x = x;
      this.y = y;
      this.state = state;
    }

    String seq(int m, int n) {
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          sb.append(state[i][j]);
        }
      }
      return sb.toString();
    }
  }

  boolean isSolved(String current) {
    return current.equals("123450");
  }

  int[][] swap(int i, int j, int x, int y, int[][] board) {
    int[][] copy = new int[board.length][board[0].length];
    for (int ik = 0; ik < board.length; ik++) {
      for (int jk = 0; jk < board[0].length; jk++) {
        copy[ik][jk] = board[ik][jk];
      }
    }

    int temp = copy[i][j];
    copy[i][j] = copy[x][y];
    copy[x][y] = temp;
    return copy;
  }

  public int slidingPuzzle(int[][] board) {
    Set<String> visited = new HashSet();
    int startRow = 0;
    int startCol = 0;
    int m = board.length;
    int n = board[0].length;
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(board[i][j]);
        if (board[i][j] == 0) {
          startRow = i;
          startCol = j;
        }
      }
    }
    visited.add(sb.toString());
    int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Queue<BFSStep> q = new LinkedList();
    q.add(new BFSStep(startRow, startCol, board));
    int path = -1;
    while(!q.isEmpty()) {
      int size = q.size();
      path++;
      for(int i = 0; i < size; i++) {
        BFSStep step = q.poll();
        if (isSolved(step.seq(m, n))) return path;
        for (int[] d : dirs) {
          int nx = step.x + d[0];
          int ny = step.y + d[1];
          if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

          int[][] swapped = swap(step.x, step.y, nx, ny, step.state);
          BFSStep node = new BFSStep(nx, ny, swapped);
          if (visited.contains(node.seq(m, n))) continue;

          visited.add(node.seq(m, n));
          q.add(node);
        }
      }
    }
    return -1;
  }
}
