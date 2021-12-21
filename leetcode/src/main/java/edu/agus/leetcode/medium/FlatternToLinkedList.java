package edu.agus.leetcode.medium;

public class FlatternToLinkedList {
  public class TreeNode {
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

  TreeNode prev = new TreeNode();

  public void preorder(TreeNode node) {
    if (node == null) return;

    TreeNode right = node.right;
    prev.right = node;
    prev.left = null;
    prev = node;
    preorder(node.left);
    preorder(right);
  }

  public void flatten(TreeNode root) {
    preorder(root);
  }
}
