package edu.agus.leetcode.easy;

public class LowestCommonAncestor {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (p.val < root.val && q.val > root.val) return root;
      if (q.val < root.val && p.val > root.val) return root;
      if (p.val == root.val) return root;
      if (q.val == root.val) return root;
      if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
      return lowestCommonAncestor(root.right, p, q);
    }
  }
}
