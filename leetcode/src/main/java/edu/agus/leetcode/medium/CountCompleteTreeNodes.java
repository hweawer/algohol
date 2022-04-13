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

  int depth(TreeNode node) {
    int d = 0;
    while(node.left != null) {
      node = node.left;
      d++;
    }
    return d;
  }

  boolean exists(int m, int d, TreeNode node) {
    int left = 0;
    int right = (int) Math.pow(2, d) - 1;

    for (int i = 0; i < d; i++) {
      int pivot = left + (right - left) / 2;
      if (m <= pivot) {
        node = node.left;
        right = pivot;
      } else {
        node = node.right;
        left = pivot + 1;
      }
    }
    return node != null;
  }

  public int countNodes(TreeNode root) {
    if (root == null) return 0;
    int d = depth(root);
    if (d == 0) return 1;

    int left = 0;
    int right = (int) Math.pow(2, d) - 1;

    int mid;
    while (left <= right) {
      mid = left + (right - left) / 2;
      if (exists(mid, d, root)) left = mid + 1;
      else right = mid - 1;
    }
    return (int) Math.pow(2, d) - 1 + left;
  }
}
