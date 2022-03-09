package edu.agus.leetcode.easy;

public class DiameterOfBST {
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

  int res = 0;

  public int rec(TreeNode node) {
    if (node.left == null && node.right == null) return 1;
    else {
      int it = 0;
      int left = 0;
      if (node.left != null) {
        left = rec(node.left);
      }
      it += left;
      int right = 0;
      if (node.right != null) {
        right = rec(node.right);
      }
      it += right;
      res = Math.max(res, it);
      return Math.max(left + 1, right + 1);
    }
  }

  public int diameterOfBinaryTree(TreeNode root) {
    rec(root);
    return res;
  }
}
