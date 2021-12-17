package edu.agus.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
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

  List<String> res = new ArrayList<>();

  public void rec(TreeNode node, String path) {
    if (node.left == null && node.right == null) {
      res.add(path + node.val);
    } else {
      if (node.left != null) {
        rec(node.left, path + node.val + "->");
      }
      if (node.right != null) {
        rec(node.right, path + node.val + "->");
      }
    }
  }

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) return res;
    rec(root, "");
    return res;
  }
}
