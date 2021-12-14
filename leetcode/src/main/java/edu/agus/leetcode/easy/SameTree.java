package edu.agus.leetcode.easy;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
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

  public boolean isSameTree(TreeNode p, TreeNode q) {
    Queue<TreeNode> q1 = new LinkedList<>();
    Queue<TreeNode> q2 = new LinkedList<>();

    q1.add(p);
    q2.add(q);

    while (!q1.isEmpty() && !q2.isEmpty()) {
      TreeNode t1 = q1.poll();
      TreeNode t2 = q2.poll();

      if (t1 == null && t2 != null) return false;
      if (t1 != null && t2 == null) return false;

      if (t1 != null && t2 != null) {
        if (t1.val != t2.val) return false;
        else {
          q1.add(t1.left);
          q1.add(t1.right);
          q2.add(t2.left);
          q2.add(t2.right);
        }
      }
    }
    return true;
  }
}
