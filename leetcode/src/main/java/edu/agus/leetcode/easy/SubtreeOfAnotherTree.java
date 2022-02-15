package edu.agus.leetcode.easy;

public class SubtreeOfAnotherTree {

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

  boolean res = false;

  public boolean compare(TreeNode current, TreeNode node) {
    if (current == null && node != null) return false;
    else if (current != null && node == null) return false;
    else if (current == null && node == null) return true;
    else {
      if (current.val != node.val) return false;
      else return compare(current.left, node.left) && compare(current.right, node.right);
    }
  }

  public void dfs(TreeNode current, TreeNode node) {
    if (current == null) return;
    dfs(current.left, node);
    if (current.val == node.val && !res) {
      res = compare(current, node);
    }
    dfs(current.right, node);
  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    dfs(root, subRoot);
    return res;
  }
}
