package edu.agus.leetcode.medium;

import edu.agus.leetcode.design.TreeNode;

public class ConvertBSTToGreaterTree {
  int acc = 0;

  void dfs(TreeNode node) {
    if (node == null) return;
    dfs(node.right);
    node.val += acc;
    acc = node.val;
    dfs(node.left);
  }

  public TreeNode convertBST(TreeNode root) {
    dfs(root);
    return root;
  }
}
