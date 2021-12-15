package edu.agus.leetcode.easy;

import java.util.*;

public class PreorderTraversal {
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

  List<Integer> result = new ArrayList<>();

  public void iterative(TreeNode root) {
    if (root == null) return;
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode top = stack.pop();
      result.add(top.val);
      if (top.right != null) stack.push(top.right);
      if (top.left != null) stack.push(top.left);
    }
  }

  public List<Integer> preorderTraversal(TreeNode root) {
    iterative(root);
    return result;
  }
}
