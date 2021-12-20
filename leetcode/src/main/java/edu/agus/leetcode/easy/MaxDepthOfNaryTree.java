package edu.agus.leetcode.easy;

import java.util.List;

public class MaxDepthOfNaryTree {
  static class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  public int dfs(Node node) {
    if (node == null || node.children.isEmpty()) return 0;
    int max = Integer.MIN_VALUE;
    for (Node c: node.children) {
      int dfsStep = dfs(c);
      if (dfsStep > max) max = dfsStep;
    }
    return 1 + max;
  }

  public int maxDepth(Node root) {
    return dfs(root);
  }
}
