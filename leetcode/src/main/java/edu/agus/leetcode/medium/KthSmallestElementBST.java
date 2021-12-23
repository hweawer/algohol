package edu.agus.leetcode.medium;

public class KthSmallestElementBST {
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

  TreeNode result = null;
  int n = 1;

  public void inorder(TreeNode node, int k) {
    if (node == null) return;
    inorder(node.left, k);
    if (n == k) result = node;
    n++;
    inorder(node.right, k);
  }

  public int kthSmallest(TreeNode root, int k) {
    inorder(root, k);
    return result.val;
  }
}
