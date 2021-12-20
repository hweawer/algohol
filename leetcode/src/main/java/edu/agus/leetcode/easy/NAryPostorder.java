package edu.agus.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class NAryPostorder {
  static class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  List<Integer> result = new ArrayList<>();

  public void post(Node node) {
    if (node == null) return;
    for (Node n : node.children) {
      post(n);
    }
    result.add(node.val);
  }

  public List<Integer> postorder(Node root) {
    post(root);
    return result;
  }
}
