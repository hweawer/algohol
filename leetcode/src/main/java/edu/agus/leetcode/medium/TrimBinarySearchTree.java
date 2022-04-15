package edu.agus.leetcode.medium;

import edu.agus.leetcode.design.TreeNode;

public class TrimBinarySearchTree {
  TreeNode dfs(TreeNode node, int low, int hight) {
    if (node == null) return null;

    TreeNode trimLeft = dfs(node.left, low, hight);
    TreeNode trimRight = dfs(node.right, low, hight);

    if (node.val >= low && node.val <= hight) {
      node.left = trimLeft;
      node.right = trimRight;
      return node;
    } else {
      if (trimLeft == trimRight && trimRight == null) return null;
      else if (trimLeft == null) return trimRight;
      else if (trimRight == null) return trimLeft;
      else {
        trimRight.left = trimLeft;
        return trimRight;
      }
    }
  }

  public TreeNode trimBST(TreeNode root, int low, int high) {
    return dfs(root, low, high);
  }
}
