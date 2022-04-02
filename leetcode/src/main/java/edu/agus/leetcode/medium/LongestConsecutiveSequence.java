package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
  class UnionFind {
    Map<Integer, Integer> parent = new HashMap();
    Map<Integer, Integer> rank = new HashMap();

    public UnionFind(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        parent.put(nums[i], nums[i]);
        rank.put(nums[i], 1);
      }
    }

    int find(int v) {
      if (!parent.containsKey(v)) return Integer.MIN_VALUE;
      if (parent.get(v) == v) return v;
      else {
        int node = find(parent.get(v));
        parent.put(v, node);
        return node;
      }
    }

    boolean union(int v, int u) {
      int rv = find(v);
      int ru = find(u);

      if (rv == ru) return false;
      if (rv == Integer.MIN_VALUE || ru == Integer.MIN_VALUE) return false;

      if (rank.get(rv) < rank.get(ru)) {
        parent.put(rv, ru);
      } else {
        parent.put(ru, rv);
        if (rank.get(rv) == rank.get(ru)) {
          int vv = rank.get(rv) + 1;
          rank.put(rv, vv);
        }
      }
      return true;
    }

    int size() {
      Map<Integer, Integer> sizes = new HashMap<>();
      for (Map.Entry<Integer, Integer> en : parent.entrySet()) {
        int x = find(en.getKey());
        int n = sizes.getOrDefault(x, 0) + 1;
        sizes.put(x, n);
      }
      int max = 0;
      for (Map.Entry<Integer, Integer> en : sizes.entrySet()) {
        max = Math.max(en.getValue(), max);
      }
      return max;
    }
  }

  public int longestConsecutive(int[] nums) {
    UnionFind uf = new UnionFind(nums);
    for (int i = 0; i < nums.length; i++) {
      uf.union(nums[i], nums[i] + 1);
      uf.union(nums[i], nums[i] - 1);
    }
    return uf.size();
  }
}
