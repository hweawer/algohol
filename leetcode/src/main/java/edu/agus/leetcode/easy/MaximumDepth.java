package edu.agus.leetcode.easy;

public class MaximumDepth {
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

  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    else return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}
