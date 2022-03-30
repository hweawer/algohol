package edu.agus.leetcode.medium;

import java.util.*;

public class MinimumNumberOfVerticesToReachAllNodes {
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    Map<Integer, Set<Integer>> dict = new HashMap();
    for (int i = 0; i < n; i++) dict.put(i, new HashSet());
    for (List<Integer> edge : edges) {
      dict.get(edge.get(1)).add(edge.get(0));
    }
    List<Integer> res = new ArrayList();
    for (Map.Entry<Integer, Set<Integer>> en : dict.entrySet()) {
      if (en.getValue().size() == 0) res.add(en.getKey());
    }
    return res;
  }
}
