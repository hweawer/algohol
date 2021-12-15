package edu.agus.leetcode.easy;

public class MinAbsoluteDifferenceInBST {
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

  int result = Integer.MAX_VALUE;
  TreeNode prev = null;

  public void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    if (prev != null) {
      result = Math.min(Math.abs(prev.val - root.val), result);
    }
    prev = root;
    inorder(root.right);
  }

  public int getMinimumDifference(TreeNode root) {
    inorder(root);
    return result;
  }
}
