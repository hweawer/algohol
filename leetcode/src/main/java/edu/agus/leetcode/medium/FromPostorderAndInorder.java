package edu.agus.leetcode.medium;

import java.util.Arrays;

public class FromPostorderAndInorder {
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

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (postorder.length == 0) return null;
    int root = postorder[postorder.length - 1];

    int m = 0;
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == root) {
        m = i;
        break;
      }
    }
    TreeNode node = new TreeNode(inorder[m]);
    node.left = buildTree(Arrays.copyOfRange(inorder, 0, m), Arrays.copyOfRange(postorder, 0, m));
    node.right = buildTree(Arrays.copyOfRange(inorder, m + 1, inorder.length), Arrays.copyOfRange(postorder, m, postorder.length - 1));
    return node;
  }
}
