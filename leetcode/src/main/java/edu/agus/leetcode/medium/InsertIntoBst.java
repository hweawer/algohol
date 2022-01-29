package edu.agus.leetcode.medium;

public class InsertIntoBst {
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

  public void insert(TreeNode node, int val) {
    if (val > node.val) {
      if (node.right == null) {
        node.right = new TreeNode(val);
      } else insert(node.right, val);
    } else {
      if (node.left == null) {
        node.left = new TreeNode(val);
      } else insert(node.left, val);
    }
  }

  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);
    insert(root, val);
    return root;
  }

}
