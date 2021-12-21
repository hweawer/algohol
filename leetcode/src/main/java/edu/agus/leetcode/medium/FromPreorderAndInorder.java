package edu.agus.leetcode.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FromPreorderAndInorder {
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

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (inorder.length == 0) return null;
    int root = preorder[0];

    int m = 0;
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == root) {
        m = i;
        break;
      }
    }
    TreeNode node = new TreeNode(inorder[m]);
    node.left = buildTree(Arrays.copyOfRange(preorder, 1, m + 1), Arrays.copyOfRange(inorder, 0, m));
    node.right = buildTree(Arrays.copyOfRange(preorder, m + 1, preorder.length), Arrays.copyOfRange(inorder, m + 1, inorder.length));
    return node;
  }
}
