package edu.agus.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointer {
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
    Queue<Node> q = new ArrayDeque<>();
    q.add(root);
    Node cur, prev = null;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        cur = q.poll();
        if (i != 0) {
          prev.next = cur;
        }
        prev = cur;
        if (cur.left != null) {
          q.add(cur.left);
        }
        if (cur.right != null) {
          q.add(cur.right);
        }
      }
    }
    return root;
  }
}
