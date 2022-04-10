package edu.agus.leetcode.hard;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class ShortestPathInAGridWithObstaclesElimination {
  class StepState {
    public int steps, row, col, k;

    public StepState(int steps, int row, int col, int k) {
      this.steps = steps;
      this.row = row;
      this.col = col;
      this.k = k;
    }

    @Override
    public int hashCode() {
      return Objects.hash(steps, row, col, k);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      StepState stepState = (StepState) o;
      return steps == stepState.steps && row == stepState.row && col == stepState.col && k == stepState.k;
    }
  }

  public int shortestPath(int[][] grid, int k) {
    int rows = grid.length, cols = grid[0].length;
    int[] target = {rows - 1, cols - 1};

    // if we have sufficient quotas to eliminate the obstacles in the worst case,
    // then the shortest distance is the Manhattan distance.
    if (k >= rows + cols - 2) {
      return rows + cols - 2;
    }

    Deque<StepState> queue = new LinkedList<>();
    HashSet<StepState> seen = new HashSet<>();

    StepState start = new StepState(0, 0, 0, k);
    queue.addLast(start);
    seen.add(start);

    while (!queue.isEmpty()) {
      StepState curr = queue.pollFirst();
      if (target[0] == curr.row && target[1] == curr.col) {
        return curr.steps;
      }

      int[] nextSteps = {curr.row, curr.col + 1, curr.row + 1, curr.col,
          curr.row, curr.col - 1, curr.row - 1, curr.col};

      for (int i = 0; i < nextSteps.length; i += 2) {
        int nextRow = nextSteps[i];
        int nextCol = nextSteps[i + 1];

        if (0 > nextRow || nextRow == rows || 0 > nextCol || nextCol == cols) {
          continue;
        }

        int nextElimination = curr.k - grid[nextRow][nextCol];
        StepState newState = new StepState(curr.steps + 1, nextRow, nextCol, nextElimination);

        if (nextElimination >= 0 && !seen.contains(newState)) {
          seen.add(newState);
          queue.addLast(newState);
        }
      }
    }

    return -1;
  }
}
