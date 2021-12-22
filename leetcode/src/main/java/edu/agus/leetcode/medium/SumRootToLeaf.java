package edu.agus.leetcode.medium;

public class SumRootToLeaf {
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

  public void dfs(TreeNode node, int x) {
    int val = x * 10 + node.val;
    if (node.right == null && node.left == null) {
      res += val;
      return;
    }
    if (node.left != null) {
      dfs(node.left, val);
    }
    if (node.right != null) {
      dfs(node.right, val);
    }
  }

  public int sumNumbers(TreeNode root) {
    dfs(root, 0);
    return res;
  }

  public static void main(String[] args) {
    SumRootToLeaf srtl = new SumRootToLeaf();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println(srtl.sumNumbers(root));
  }
}
