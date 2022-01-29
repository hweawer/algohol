package edu.agus.leetcode.easy;

public class SearchInBST {
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

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) return null;
    else if (root.val == val) return root;
    else if (val > root.val) return searchBST(root.right, val);
    else return searchBST(root.left, val);
  }
}
