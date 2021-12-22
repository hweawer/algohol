package edu.agus.leetcode.medium;

public class CountCompleteTreeNodes {
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

  public int countNodes(TreeNode root) {
    if (root == null) return 0;
    else return 1 + countNodes(root.left) + countNodes(root.right);
  }
}
