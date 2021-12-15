package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
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

  List<List<Integer>> result = new ArrayList<>();

  public static class Elem {
    public TreeNode node;
    public int level;

    public Elem(TreeNode node, int level) {
      this.node = node;
      this.level = level;
    }
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return result;
    int currentLevel = 1;
    List<Integer> level = new ArrayList<>();
    Queue<Elem> queue = new LinkedList<>();
    queue.add(new Elem(root, 1));
    while (!queue.isEmpty()) {
      Elem first = queue.poll();
      if (currentLevel != first.level) {
        result.add(level);
        level = new ArrayList<>();
        currentLevel = first.level;
      }
      level.add(first.node.val);
      if (first.node.left != null) queue.add(new Elem(first.node.left, first.level + 1));
      if (first.node.right != null) queue.add(new Elem(first.node.right, first.level + 1));
    }
    result.add(level);
    return result;
  }
}
