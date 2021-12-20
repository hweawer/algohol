package edu.agus.leetcode.medium;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class RecoverBST {
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

  public void swap(TreeNode x, TreeNode y) {
    int xVal = x.val;
    x.val = y.val;
    y.val = xVal;
  }

  TreeNode first = null;
  TreeNode second = null;
  TreeNode prev = new TreeNode(Integer.MIN_VALUE);

  public void inorder(TreeNode node) {
    if (node == null) return;
    inorder(node.left);
    if (first == null && prev.val > node.val) {
      first = prev;
    }
    if (first != null && prev.val > node.val) {
      second = node;
    }
    prev = node;
    inorder(node.right);
  }

  public void recoverTree(TreeNode root) {
    inorder(root);
    swap(first, second);
  }
}
