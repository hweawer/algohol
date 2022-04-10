package edu.agus.leetcode.medium;

import java.util.*;

public class FindDuplicateSubtrees {
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

  Set<String> returned = new HashSet();
  Map<String, TreeNode> pathToRoot = new HashMap();
  List<TreeNode> result = new ArrayList();

  String dfs(TreeNode node) {
    if (node == null) return "";
    String pathLeft = dfs(node.left);
    String pathRight = dfs(node.right);
    String path = "L" + pathLeft + node.val + "R" + pathRight;
    if (!pathToRoot.containsKey(path)) {
      pathToRoot.put(path, node);
    } else {
      if (!returned.contains(path)) {
        result.add(node);
        returned.add(path);
      }
    }
    return path;
  }


  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    dfs(root);
    return result;
  }
}
