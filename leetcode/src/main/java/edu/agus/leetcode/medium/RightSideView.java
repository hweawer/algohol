package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
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

  public void bfs(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        root = q.poll();
        if (i == size - 1) {
          result.add(root.val);
        }
        if (root.left != null) q.add(root.left);
        if (root.right != null) q.add(root.right);
      }
    }
  }

  public List<Integer> rightSideView(TreeNode root) {
    bfs(root);
    return result;
  }
}
