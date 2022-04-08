package edu.agus.leetcode.easy;

import java.util.PriorityQueue;

public class KthLargest {
  PriorityQueue<Integer> pq;
  int k;

  public KthLargest(int k, int[] nums) {
    pq = new PriorityQueue();
    this.k = k;

    for (int n : nums) {
      pq.add(n);
    }

    while (k < pq.size()) {
      pq.poll();
    }
  }

  public int add(int val) {
    pq.add(val);
    while (k < pq.size()) {
      pq.poll();
    }
    return pq.peek();
  }
}
