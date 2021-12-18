package edu.agus.leetcode.easy;

public class BinaryTreeTilt {
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

  public int rec(TreeNode root) {
    if (root == null) return 0;
    else if (root.left == null && root.right == null) return root.val;
    else {
      if (root.left == null) {
        int r = rec(root.right);
        result += Math.abs(r);
        return root.val + r;
      }
      if (root.right == null) {
        int l = rec(root.left);
        result += Math.abs(l);
        return root.val + l;
      }
      int l = rec(root.left);
      int r = rec(root.right);
      result += Math.abs(l - r);
      return root.val + l + r;
    }
  }

  public int findTilt(TreeNode root) {
    rec(root);
    return result;
  }
}
