package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRootOfNAryTree {
  class Node {
    public int val;
    public List<Node> children;

    public Node() {
      children = new ArrayList<>();
    }

    public Node(int _val) {
      val = _val;
      children = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  void dfs(Node node, Map<Node, Boolean> candidates) {
    for (Node child : node.children) {
      if (candidates.containsKey(child) && !candidates.get(child)) continue;
      candidates.put(child, false);
      dfs(child, candidates);
    }
  }

  public Node findRoot(List<Node> tree) {
    Map<Node, Boolean> candidates = new HashMap<>();
    for (Node node : tree) {
      if (!candidates.containsKey(node)) {
        candidates.put(node, true);
        dfs(node, candidates);
      }
    }
    for (Map.Entry<Node, Boolean> en : candidates.entrySet()) {
      if (en.getValue()) return en.getKey();
    }
    return null;
  }
}
