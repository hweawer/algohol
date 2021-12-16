package edu.agus.leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePostorderTraversal {
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

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    else {
      Deque<TreeNode> stack = new ArrayDeque<>();
      Deque<TreeNode> res = new ArrayDeque<>();
      stack.add(root);
      while (!stack.isEmpty()) {
        TreeNode top = stack.pop();
        res.push(top);

        if (top.left != null) {
          stack.push(top.left);
        }
        if (top.right != null) {
          stack.push(top.right);
        }
      }
      while (!res.isEmpty()) {
        result.add(res.pop().val);
      }
    }
    return result;
  }
}
