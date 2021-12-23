package edu.agus.leetcode.easy;

public class SumOfLeftLeaves {
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

  public int dfs(TreeNode root) {
    if (root == null) return 0;
    else if (root.left != null && root.left.left == null && root.left.right == null)
      return root.left.val + dfs(root.right);
    else return dfs(root.left) + dfs(root.right);
  }

  public int sumOfLeftLeaves(TreeNode root) {
    return dfs(root);
  }
}
