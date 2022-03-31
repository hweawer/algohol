package edu.agus.leetcode.medium;

public class ConvertBSTtoSortedDoublyLinkedList {
  class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }
  }

  Node first = null;
  Node last = null;

  void inOrderTraverse(Node root) {
    if (root == null) return;
    inOrderTraverse(root.left);
    if (last != null) {
      last.right = root;
      root.left = last;
    } else {
      first = root;
    }
    last = root;
    inOrderTraverse(root.right);
  }

  public Node treeToDoublyList(Node root) {
    if (root == null) return null;
    inOrderTraverse(root);
    last.right = first;
    first.left = last;
    return first;
  }
}
