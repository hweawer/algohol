package edu.agus.leetcode.medium;

public class MaximumBinaryTree {
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

  public int maxInd(int[] nums, int l, int r) {
    int m = l;
    for (int i = l; i <= r; i++) {
      if (nums[i] > nums[m]) m = i;
    }
    return m;
  }

  public TreeNode tree(int[] nums, int l, int r) {
    if (l > r) return null;
    int m = maxInd(nums, l, r);
    TreeNode node = new TreeNode(nums[m]);
    node.left = tree(nums, l, m - 1);
    node.right = tree(nums, m + 1, r);
    return node;
  }

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return tree(nums, 0, nums.length - 1);
  }
}
