package edu.agus.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimeNeededToInformAllEmployees {
  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    List<Integer>[] ajastency = new List[n];
    for (int i = 0; i < n; i++) {
      ajastency[i] = new LinkedList<>();
    }
    for (int i = 0; i < manager.length; i++) {
      if (manager[i] != -1) {
        ajastency[manager[i]].add(i);
      }
    }
    Queue<Integer> q = new LinkedList<>();
    q.add(headID);
    int result = 0;
    while (!q.isEmpty()) {
      int root = q.poll();
      List<Integer> children = ajastency[root];
      for (int c : children) {
        informTime[c] += informTime[root];
        result = Math.max(result, informTime[c]);
        q.add(c);
      }
    }
    return result;
  }
}
