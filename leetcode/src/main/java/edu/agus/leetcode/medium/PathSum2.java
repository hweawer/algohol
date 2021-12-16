package edu.agus.leetcode.medium;

import java.util.*;

public class PathSum2 {
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

  public class Elem {
    TreeNode node;
    int sum;
    List<Integer> path;

    public Elem(TreeNode node, int sum) {
      this(node, sum, new ArrayList<>());
    }

    public Elem(TreeNode node, int sum, List<Integer> path) {
      this.node = node;
      this.sum = sum;
      this.path = path;
    }
  }

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    Deque<Elem> stack = new ArrayDeque<>();
    List<Integer> path = new ArrayList<>();
    path.add(root.val);
    stack.push(new Elem(root, root.val, path));
    while (!stack.isEmpty()) {
      Elem top = stack.pop();
      if (top.node.left == null && top.node.right == null) {
        if (top.sum == targetSum) result.add(top.path);
      }
      if (top.node.left != null) {
        List<Integer> newPath = new ArrayList<>(top.path);
        newPath.add(top.node.left.val);
        stack.push(new Elem(top.node.left, top.sum + top.node.left.val, newPath));
      }
      if (top.node.right != null) {
        List<Integer> newPath = new ArrayList<>(top.path);
        newPath.add(top.node.right.val);
        stack.push(new Elem(top.node.right, top.sum + top.node.right.val, newPath));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    TreeNode left = new TreeNode(4);
    TreeNode right = new TreeNode(8);
    root.left = left;
    root.right = right;
    PathSum2 s = new PathSum2();
    s.pathSum(root, 9);
  }
}
