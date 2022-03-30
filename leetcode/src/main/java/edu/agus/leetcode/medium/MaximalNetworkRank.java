package edu.agus.leetcode.medium;

import java.util.*;

public class MaximalNetworkRank {
  public int maximalNetworkRank(int n, int[][] roads) {
    Map<Integer, Set<Integer>> connections = new HashMap();
    for (int i = 0; i < n; i++) {
      connections.put(i, new HashSet());
    }
    for (int[] road : roads) {
      connections.get(road[0]).add(road[1]);
      connections.get(road[1]).add(road[0]);
    }
    int max = 0;
    for (Map.Entry<Integer, Set<Integer>> i : connections.entrySet()) {
      for (Map.Entry<Integer, Set<Integer>> j : connections.entrySet()) {
        if (!Objects.equals(i.getKey(), j.getKey())) {
          int rank = i.getValue().size() + j.getValue().size();
          if (i.getValue().contains(j.getKey())) rank--;
          max = Math.max(max, rank);
        }
      }
    }
    return max;
  }
}
