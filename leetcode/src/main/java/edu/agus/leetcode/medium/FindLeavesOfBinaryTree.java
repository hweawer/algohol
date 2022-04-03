package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
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

  List<List<Integer>> res = new ArrayList();

  int dfs(TreeNode node) {
    if (node == null) return -1;
    else {
      int ll = dfs(node.left);
      int rl = dfs(node.right);
      int idx = Math.max(ll, rl) + 1;
      if (res.size() - 1 < idx) {
        List<Integer> r = new ArrayList();
        r.add(node.val);
        res.add(r);
      } else {
        res.get(idx).add(node.val);
      }
      return idx;
    }
  }

  public List<List<Integer>> findLeaves(TreeNode root) {
    dfs(root);
    return res;
  }
}
