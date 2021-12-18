package edu.agus.leetcode.easy;

import java.util.HashMap;

public class SumOfTwo4UsingBST {
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

  HashMap<Integer, Boolean> map = new HashMap<>();
  boolean result = false;

  public void inOrder(TreeNode node, int k) {
    if (node == null) return;
    else {
      inOrder(node.left, k);
      int delta = k - node.val;
      if (map.containsKey(delta)) {
        result = true;
      }
      map.put(node.val, true);
      inOrder(node.right, k);
    }
  }

  public boolean findTarget(TreeNode root, int k) {
    inOrder(root, k);
    return result;
  }
}
