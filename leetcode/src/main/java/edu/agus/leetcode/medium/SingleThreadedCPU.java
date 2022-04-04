package edu.agus.leetcode.medium;

import java.util.*;

public class SingleThreadedCPU {
  static class Task {
    int idx;
    int start;
    int dur;

    Task(int idx, int start, int dur) {
      this.idx = idx;
      this.start = start;
      this.dur = dur;
    }
  }

  public int[] getOrder(int[][] tasks) {
    List<Integer> res = new ArrayList<>();
    List<Task> at = new ArrayList<>();
    for (int i = 0; i < tasks.length; i++) {
      at.add(new Task(i, tasks[i][0], tasks[i][1]));
    }
    at.sort((x, y) -> {
      if (x.start > y.start) return 1;
      else if (x.start < y.start) return -1;
      else return Integer.compare(x.dur, y.dur);
    });
    int curTime = at.get(0).start;
    PriorityQueue<Task> pq = new PriorityQueue<>(Comparator.comparingInt((Task x) -> x.dur).thenComparingInt(x -> x.idx));
    pq.add(at.get(0));
    int i = 1;
    while (i < at.size() || !pq.isEmpty()) {
      Task task = pq.poll();
      res.add(task.idx);
      curTime += task.dur;
      if (i < at.size() && pq.isEmpty() && curTime < at.get(i).start) curTime = at.get(i).start;
      while (i < at.size() && curTime >= at.get(i).start) {
        pq.add(at.get(i++));
      }
    }
    int[] ans = new int[res.size()];
    for (int j = 0; j < res.size(); j++) {
      ans[j] = res.get(j);
    }
    return ans;
  }

  public static void main(String[] args) {
    SingleThreadedCPU stc = new SingleThreadedCPU();
    stc.getOrder(new int[][]{
        {1, 2}, {2, 4}, {3, 2}, {4, 1}
 //       {35, 36}, {11, 7}, {15, 47}, {34, 2}, {47, 19}, {16, 14}, {19, 8}, {7, 34}, {38, 15}, {16, 18}, {27, 22}, {7, 15}, {43, 2}, {10, 5}, {5, 4}, {3, 11}
    });
  }
}
