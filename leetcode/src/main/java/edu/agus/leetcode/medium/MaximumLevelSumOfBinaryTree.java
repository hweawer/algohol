package edu.agus.leetcode.medium;

import edu.agus.leetcode.design.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfBinaryTree {
  public int maxLevelSum(TreeNode root) {
    Queue<TreeNode> q = new LinkedList();
    q.add(root);
    int ans = 0;
    int maxSum = Integer.MIN_VALUE;

    int level = 0;
    int curSum = 0;
    while(!q.isEmpty()) {
      int size = q.size();
      level++;
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        curSum += node.val;

        if (node.left != null) q.add(node.left);
        if (node.right != null) q.add(node.right);
      }

      if (curSum > maxSum) {
        ans = level;
        maxSum = curSum;
      }

      curSum = 0;
    }
    return ans;
  }
}
