package edu.agus.leetcode.medium;

public class BinaryTreeColoringGame {
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

  int left, right;

  int dfs(TreeNode node, int x) {
    if (node == null) return 0;

    int l = dfs(node.left, x);
    int r = dfs(node.right, x);
    if (node.val == x) {
      left = l;
      right = r;
    }
    return l + r + 1;
  }

  public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    dfs(root, x);
    return Math.max(Math.max(left, right), n - left - right - 1) > n / 2;
  }
}
