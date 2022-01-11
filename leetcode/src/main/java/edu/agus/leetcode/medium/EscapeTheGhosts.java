package edu.agus.leetcode.medium;

public class EscapeTheGhosts {
  public int manhattanDistance(int[] x, int[] y) {
    return Math.abs(y[0] - x[0]) + Math.abs(y[1] - x[1]);
  }

  public boolean escapeGhosts(int[][] ghosts, int[] target) {
    int initDist = manhattanDistance(new int[]{0, 0}, target);
    for (int i = 0; i < ghosts.length; i++) {
      int ghostDist = manhattanDistance(ghosts[i], target);
      if (ghostDist <= initDist) return false;
    }
    return true;
  }
}
