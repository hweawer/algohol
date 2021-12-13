package edu.agus.leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InorderTraversal {
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

  List<Integer> res = new ArrayList<>();

  public void recursive(TreeNode root) {
    if (root == null) return;
    else {
      recursive(root.left);
      res.add(root.val);
      recursive(root.right);
    }
  }

  //todo: Inspect it
  public List<Integer> morisTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    TreeNode curr = root;
    TreeNode pre;
    while (curr != null) {
      if (curr.left == null) {
        res.add(curr.val);
        curr = curr.right; // move to next right node
      } else { // has a left subtree
        pre = curr.left;
        while (pre.right != null) { // find rightmost
          pre = pre.right;
        }
        pre.right = curr; // put cur after the pre node
        TreeNode temp = curr; // store cur node
        curr = curr.left; // move cur to the top of the new tree
        temp.left = null; // original cur left be null, avoid infinite loops
      }
    }
    return res;
  }

  public List<Integer> iterative(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> deque = new ArrayDeque<>();
    TreeNode cur = root;
    while (cur != null || deque.isEmpty()) {
      while (cur != null) {
        deque.push(cur);
        cur = cur.left;
      }
      cur = deque.pop();
      result.add(cur.val);
      cur = cur.right;
    }
    return result;
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    return iterative(root);
  }
}
