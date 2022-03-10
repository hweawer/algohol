package edu.agus.leetcode.medium;

public class SortedListToBST {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

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

  ListNode findMid(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    ListNode prev = null;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    if (prev != null) {
      prev.next = null;
    }
    return slow;
  }

  public TreeNode rec(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return new TreeNode(head.val);
    ListNode mid = findMid(head);
    TreeNode left = rec(head);
    TreeNode right = rec(mid.next);
    return new TreeNode(mid.val, left, right);
  }

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return new TreeNode(head.val);
    return rec(head);
  }
}
