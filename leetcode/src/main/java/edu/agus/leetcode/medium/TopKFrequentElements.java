package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
  public class Pair {
    int first;
    int second;

    public Pair(int f, int s) {
      this.first = f;
      this.second = s;
    }
  }

  public int[] topKFrequent(int[] nums, int k) {
    PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o2.second - o1.second);
    int[] res = new int[k];
    HashMap<Integer, Integer> dict = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int val = dict.getOrDefault(nums[i], 0) + 1;
      dict.put(nums[i], val);
    }
    dict.forEach((key, value) -> pq.add(new Pair(key, value)));
    for (int i = 0; i < k; i++) {
      res[i] = pq.poll().first;
    }
    return res;
  }
}
