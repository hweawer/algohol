package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigZag {
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

  List<List<Integer>> traversal = new ArrayList<>();

  public void dfs(TreeNode node, int level) {
    if (node == null) return;
    if (traversal.size() < level) {
      List<Integer> la = new ArrayList<>();
      la.add(node.val);
      traversal.add(la);
    } else {
      List<Integer> la = traversal.get(level - 1);
      if (level % 2 == 0) la.add(0, node.val);
      else la.add(node.val);
    }
    dfs(node.left, level + 1);
    dfs(node.right, level + 1);
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    dfs(root, 1);
    return traversal;
  }
}
