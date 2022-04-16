package edu.agus.leetcode.medium;

import edu.agus.leetcode.design.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
  TreeNode res;

  boolean dfs(TreeNode node, int p, int q) {
    if (node == null || res != null) return false;

    int cur = node.val == p || node.val == q ? 1 : 0;
    int left = dfs(node.left, p, q) ? 1 : 0;
    int right = dfs(node.right, p, q) ? 1 : 0;

    int result = cur + left + right;
    if (result == 2) res = node;
    return result > 0;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    dfs(root, p.val, q.val);
    return res;
  }
}
