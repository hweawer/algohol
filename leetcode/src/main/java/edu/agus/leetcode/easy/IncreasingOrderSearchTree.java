package edu.agus.leetcode.easy;

import edu.agus.leetcode.design.TreeNode;

public class IncreasingOrderSearchTree {
  TreeNode head = null;
  TreeNode last = null;

  void dfs(TreeNode node) {
    if (node == null) return;

    dfs(node.left);
    if (head == null) {
      head = node;
    } else {
      last.right = node;
      node.left = null;
    }
    last = node;
    dfs(node.right);
  }

  public TreeNode increasingBST(TreeNode root) {
    dfs(root);
    return head;
  }
}
