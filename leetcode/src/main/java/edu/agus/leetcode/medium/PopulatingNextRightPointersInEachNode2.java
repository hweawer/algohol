package edu.agus.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode2 {
  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

  public Node connect(Node root) {
    if (root == null) return root;
    Queue<Node> q = new LinkedList();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      Node prev = null;
      for (int i = 0; i < size; i++) {
        Node top = q.poll();
        top.next = prev;
        prev = top;
        if (top.right != null) {
          q.add(top.right);
        }
        if (top.left != null) {
          q.add(top.left);
        }
      }
    }
    return root;
  }
}
