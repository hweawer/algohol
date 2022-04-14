package edu.agus.leetcode.hard;

import edu.agus.leetcode.design.TreeNode;

public class BinaryTreeMaximumPathSum {
  int result = Integer.MIN_VALUE;

  int dfs(TreeNode node) {
    if (node == null) return 0;
    int left = Math.max(dfs(node.left), 0);
    int right = Math.max(dfs(node.right), 0);

    int path = node.val + left + right;

    result = Math.max(result, path);
    return node.val + Math.max(left, right);
  }

  public int maxPathSum(TreeNode root) {
    dfs(root);
    return result;
  }
}
