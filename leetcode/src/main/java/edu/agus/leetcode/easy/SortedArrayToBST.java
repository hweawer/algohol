package edu.agus.leetcode.easy;

public class SortedArrayToBST {
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

  public TreeNode recursive(int[] nums, int l, int r) {
    if (r < l || r >= nums.length) return null;
    else {
      int m = (l + r) / 2;
      TreeNode root = new TreeNode(nums[m]);
      root.left = recursive(nums, l, m - 1);
      root.right = recursive(nums, m + 1, r);
      return root;
    }
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return recursive(nums, 0, nums.length - 1);
  }
}
