package edu.agus.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {
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

  public void insert(TreeNode x, int val) {
    TreeNode left = new TreeNode(val);
    left.left = x.left;
    x.left = left;
    TreeNode right = new TreeNode(val);
    right.right = x.right;
    x.right = right;
  }

  public TreeNode addOneRow(TreeNode root, int val, int depth) {
    if (depth == 1) {
      TreeNode newRoot = new TreeNode(val);
      newRoot.left = root;
      return newRoot;
    }
    Queue<TreeNode> q = new LinkedList<>();
    int currentDepth = 1;
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode top = q.poll();
        if (currentDepth + 1 != depth) {
          if (top.right != null) q.add(top.right);
          if (top.left != null) q.add(top.left);
        } else {
          insert(top, val);
        }
      }
      currentDepth++;
    }
    return root;
  }
}
