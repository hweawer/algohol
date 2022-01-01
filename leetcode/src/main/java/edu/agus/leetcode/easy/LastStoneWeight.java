package edu.agus.leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

public class LastStoneWeight {
  Comparator<Integer> cmp = (x, y) -> y - x;

  public int lastStoneWeight(int[] stones) {
    List<Integer> sl = Arrays.stream(stones).boxed().collect(Collectors.toList());
    Queue<Integer> q = new PriorityQueue<>(cmp);
    q.addAll(sl);
    while (q.size() > 1) {
      int top1 = q.poll();
      int top2 = q.poll();
      if (top1 != top2) {
        q.add(top1 - top2);
      }
    }
    return q.size() == 1 ? q.poll() : 0;
  }
}
