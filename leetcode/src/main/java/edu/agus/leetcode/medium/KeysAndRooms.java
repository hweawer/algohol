package edu.agus.leetcode.medium;

import java.util.List;

public class KeysAndRooms {
  boolean[] visited;

  public void dfs(List<List<Integer>> rooms, int room) {
    if (visited[room]) return;
    visited[room] = true;
    for (int key : rooms.get(room)) dfs(rooms, key);
  }

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    visited = new boolean[rooms.size()];
    dfs(rooms, 0);
    for (boolean visit : visited) {
      if (!visit) return false;
    }
    return true;
  }
}
