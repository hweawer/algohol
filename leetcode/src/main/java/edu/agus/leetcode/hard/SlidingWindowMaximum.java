package edu.agus.leetcode.hard;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
  public int[] maxSlidingWindow(int[] nums, int k) {
    List<Integer> res = new ArrayList<>();
    Deque<Integer> deq = new LinkedList<>();
    for (int i = 0; i < k; i++) {
      int it = nums[i];
      if (deq.isEmpty() || deq.getFirst() > it) deq.push(it);
      else {
        while (!deq.isEmpty() && deq.getFirst() < it) deq.pop();
        deq.push(it);
      }
    }
    res.add(deq.getFirst());
    if (deq.getFirst() == nums[0]) deq.removeFirst();
    for (int right = k; right < nums.length; right++) {
      int left = right - k + 1;
      int it = nums[right];
      while (!deq.isEmpty() && deq.getFirst() < it) deq.pop();
      deq.push(it);
      res.add(deq.getFirst());
      if (deq.getFirst() == nums[left]) deq.removeFirst();
    }
    int[] ans = new int[res.size()];
    for (int i = 0; i < res.size(); i++) {
      ans[i] = res.get(i);
    }
    return ans;
  }
}
