package edu.agus.leetcode.medium;

public class StepByStepDirectionsFromBinaryTreeNodeToAnother {
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

  String start = null;
  String finish = null;

  void dfs(TreeNode root, int startValue, int destValue, StringBuilder sb) {
    if (root == null || (start != null && finish != null)) {
      return;
    } else {
      if (root.val == startValue) {
        start = sb.toString();
      } else if (root.val == destValue) {
        finish = sb.toString();
      }
      sb.append('L');
      dfs(root.left, startValue, destValue, sb);
      sb.deleteCharAt(sb.length() - 1);
      sb.append('R');
      dfs(root.right, startValue, destValue, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public String getDirections(TreeNode root, int startValue, int destValue) {
    dfs(root, startValue, destValue, new StringBuilder());
    int x = 0;
    while (x < start.length() && x < finish.length() && start.charAt(x) == finish.charAt(x)) {
      x++;
    }
    StringBuilder trimmedStart = new StringBuilder(start.substring(x, start.length()));
    StringBuilder finishStart = new StringBuilder(finish.substring(x, finish.length()));
    for (int i = 0; i < trimmedStart.length(); i++) {
      trimmedStart.setCharAt(i, 'U');
    }
    return trimmedStart.toString() + finishStart.toString();
  }
}
