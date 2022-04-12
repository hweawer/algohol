package edu.agus.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {

  class Pair {
    int x;
    int y;

    Pair(int f, int s) {
      this.x = f;
      this.y = s;
    }
  }

  interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();

    void turnRight();

    // Clean the current cell.
    void clean();
  }

  class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Pair> visited = new HashSet();
    Robot robot;

    void goBack() {
      robot.turnRight();
      robot.turnRight();
      robot.move();
      robot.turnRight();
      robot.turnRight();
    }

    void backtrack(int x, int y, int d) {
      visited.add(new Pair(x, y));
      robot.clean();

      for (int i = 0; i < 4; i++) {
        int newD = (d + i) % 4;
        int nx = x + dirs[newD][0];
        int ny = y + dirs[newD][1];
        if (!visited.contains(new Pair(nx, ny)) && robot.move()) {
          backtrack(nx, ny, newD);
          goBack();
        }
        robot.turnRight();
      }
    }

    public void cleanRoom(Robot robot) {
      this.robot = robot;
      backtrack(0, 0, 0);
    }
  }
}
