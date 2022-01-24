package edu.agus.leetcode.medium;

import java.util.HashMap;

public class DeleteAndEarn {
  public int deleteAndEarn(int[] nums) {
    int min = Integer.MAX_VALUE;
    int max = 0;

    HashMap<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      int v = map.getOrDefault(n, 0) + n;
      map.put(n, v);
      min = Math.min(min, n);
      max = Math.max(max, n);
    }

    int[] mem = new int[max + 1];
    mem[min] = map.get(min);

    for (int i = min + 1; i <= max; i++) {
      mem[i] = Math.max(mem[i - 1], mem[i - 2] + map.getOrDefault(i, 0));
    }

    return mem[max];
  }
}
