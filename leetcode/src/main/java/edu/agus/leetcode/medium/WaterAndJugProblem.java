package edu.agus.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WaterAndJugProblem {
  public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
    if (jug1Capacity + jug2Capacity < targetCapacity) return false;
    int[] dirs = {jug1Capacity, -jug1Capacity, jug2Capacity, -jug2Capacity};
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();
    q.add(0);
    while (!q.isEmpty()) {
      int top = q.poll();
      if (top == targetCapacity) return true;
      if (visited.contains(top)) continue;
      visited.add(top);
      for (int dir : dirs) {
        int total = top + dir;
        if (total > 0 && total < jug1Capacity + jug2Capacity + 1 && !visited.contains(total)) {
          q.add(total);
        }
      }
    }
    return false;
  }
}
