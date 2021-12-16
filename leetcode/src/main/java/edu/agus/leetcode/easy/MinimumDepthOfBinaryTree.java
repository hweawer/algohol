package edu.agus.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumDepthOfBinaryTree {
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

  public class Elem {
    TreeNode node;
    int depth;

    public Elem(TreeNode node, int depth) {
      this.node = node;
      this.depth = depth;
    }
  }

  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    else {
      int result = Integer.MAX_VALUE;
      Deque<Elem> stack = new ArrayDeque<>();
      stack.add(new Elem(root, 1));
      while (!stack.isEmpty()) {
        Elem top = stack.pop();
        if (top.node.left != null) stack.add(new Elem(top.node.left, top.depth + 1));
        if (top.node.right != null) stack.add(new Elem(top.node.right, top.depth + 1));
        if (top.node.left == null && top.node.right == null && top.depth < result) result = top.depth;
      }
      return result;
    }
  }
}
