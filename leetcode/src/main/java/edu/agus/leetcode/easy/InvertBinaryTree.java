package edu.agus.leetcode.easy;

public class InvertBinaryTree {
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

  public TreeNode invert(TreeNode node) {
    if (node == null) return null;
    else {
      TreeNode left = node.left;
      node.left = invertTree(node.right);
      node.right = invertTree(left);
      return node;
    }
  }

  public TreeNode invertTree(TreeNode root) {
    return invert(root);
  }
}
