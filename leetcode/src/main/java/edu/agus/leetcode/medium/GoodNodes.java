package edu.agus.leetcode.medium;

public class GoodNodes {
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

  int result = 0;

  public void dfs(TreeNode node, int max) {
    if (node == null) return;
    if (node.val >= max) result++;
    max = Math.max(node.val, max);
    dfs(node.left, max);
    dfs(node.right, max);
  }

  public int goodNodes(TreeNode root) {
    if (root == null) return result;
    dfs(root, root.val);
    return result;
  }

}
