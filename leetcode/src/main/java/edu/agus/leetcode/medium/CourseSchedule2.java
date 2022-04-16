package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule2 {
  List<Integer>[] adj;
  Set<Integer> visited = new HashSet();
  Set<Integer> track = new HashSet();
  boolean isCycle = false;
  int[] result;
  int idx = 0;

  void dfs(int i) {
    if (isCycle || track.contains(i)) return;
    if (visited.contains(i)) {
      isCycle = true;
      return;
    }
    List<Integer> req = adj[i];
    if (!req.isEmpty()) {
      visited.add(i);
      for(int r : req) dfs(r);
      visited.remove(i);
      adj[i] = new ArrayList();
    }
    result[idx++] = i;
    track.add(i);
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    result = new int[numCourses];
    adj = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; i++) {
      adj[i] = new ArrayList();
    }
    for (int[] preq : prerequisites) {
      adj[preq[0]].add(preq[1]);
    }
    for (int i = 0; i < numCourses; i++) {
      dfs(i);
      if (isCycle) return new int[]{};
    }
    return result;
  }
}
