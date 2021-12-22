package edu.agus.leetcode.design;

import java.util.ArrayDeque;
import java.util.Deque;

class BSTIterator {
  private final Deque<TreeNode> stack;

  private void reverseTraversal(TreeNode node) {
    if (node == null) return;
    reverseTraversal(node.right);
    stack.push(node);
    reverseTraversal(node.left);
  }

  public BSTIterator(TreeNode root) {
    stack = new ArrayDeque<>();
    reverseTraversal(root);
  }

  public int next() {
    return stack.pop().val;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }
}
