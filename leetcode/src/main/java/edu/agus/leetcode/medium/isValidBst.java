package edu.agus.leetcode.medium;

public class isValidBst {
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

  public boolean isValidNode(TreeNode node, Integer max, Integer min) {
    if (node == null) return true;
    else if (max != null && node.val > max) return false;
    else if (min != null && node.val < min) return false;
    else return isValidNode(node.right, max, node.val) && isValidNode(node.left, node.val, min);
  }

  public boolean isValidBST(TreeNode root) {
    return isValidNode(root, null, null);
  }
}
