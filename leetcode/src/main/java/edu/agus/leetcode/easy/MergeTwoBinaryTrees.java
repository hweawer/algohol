package edu.agus.leetcode.easy;

public class MergeTwoBinaryTrees {
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

  public TreeNode merge(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return null;
    else if (root1 != null && root2 == null)
      return new TreeNode(root1.val, merge(root1.left, null), merge(root1.right, null));
    else if (root1 == null && root2 != null)
      return new TreeNode(root2.val, merge(null, root2.left), merge(null, root2.right));
    else {
      return new TreeNode(root1.val + root2.val, merge(root1.left, root2.left), merge(root1.right, root2.right));
    }
  }

  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    return merge(root1, root2);
  }
}
