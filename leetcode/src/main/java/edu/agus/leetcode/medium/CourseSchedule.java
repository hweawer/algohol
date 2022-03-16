package edu.agus.leetcode.medium;

import java.util.*;

public class CourseSchedule {
  LinkedList<Integer>[] adjList;
  Set<Integer> visit = new HashSet<>();

  public boolean dfs(int key) {
    if (visit.contains(key)) return false;
    if (adjList[key].isEmpty()) return true;
    visit.add(key);
    while (!adjList[key].isEmpty()) {
      if (!dfs(adjList[key].getFirst())) return false;
      adjList[key].removeFirst();
    }
    visit.remove(key);
    return true;
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites.length == 0) return true;
    adjList = new LinkedList[numCourses];
    for (int i = 0; i < numCourses; i++) {
      adjList[i] = new LinkedList<>();
    }
    for (int[] req : prerequisites) adjList[req[0]].add(req[1]);
    for (int i = 0; i < numCourses; i++) {
      if (!dfs(i)) return false;
    }
    return true;
  }
}
