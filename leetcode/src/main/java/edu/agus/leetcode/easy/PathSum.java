package edu.agus.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class PathSum {
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

  public static class StackElem {
    TreeNode node;
    int sum;

    StackElem(TreeNode node, int sum) {
      this.node = node;
      this.sum = sum;
    }
  }

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    Deque<StackElem> stack = new ArrayDeque<>();
    stack.push(new StackElem(root, root.val));

    while (!stack.isEmpty()) {
      StackElem top = stack.pop();
      if (top.node.left == null && top.node.right == null) {
        if (top.sum == targetSum) return true;
      }

      if (top.node.left != null) {
        stack.push(new StackElem(top.node.left, top.sum + top.node.left.val));
      }

      if (top.node.right != null) {
        stack.push(new StackElem(top.node.right, top.sum + top.node.right.val));
      }
    }
    return false;
  }
}
