package edu.agus.leetcode.medium;

import edu.agus.leetcode.design.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
  List<TreeNode> result = new ArrayList();
  Set<Integer> elimination = new HashSet();

  TreeNode dfs(TreeNode node) {
    if (node == null) return null;

    TreeNode left = dfs(node.left);
    TreeNode right = dfs(node.right);
    node.left = left;
    node.right = right;
    if (elimination.contains(node.val)) {
      if (left != null) {
        result.add(left);
      }

      if (right != null) {
        result.add(right);
      }
      node = null;
    }
    return node;
  }

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    for (int x : to_delete) {
      elimination.add(x);
    }
    if (!elimination.contains(root.val)) {
      result.add(root);
    }
    dfs(root);
    return result;
  }
}
