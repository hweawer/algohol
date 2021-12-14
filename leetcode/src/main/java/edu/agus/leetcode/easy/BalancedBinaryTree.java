package edu.agus.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBinaryTree {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  boolean balanced = true;

  public int dfs(TreeNode root) {
    if (root == null) return 0;
    int leftHeight = dfs(root.left);
    int rightHeight = dfs(root.right);
    if (Math.abs(leftHeight - rightHeight) > 1) balanced = false;
    return Math.max(leftHeight, rightHeight) + 1;
  }

  public boolean isBalanced(TreeNode root) {
    dfs(root);
    return balanced;
  }
}
