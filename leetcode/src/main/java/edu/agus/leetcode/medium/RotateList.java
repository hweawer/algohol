package edu.agus.leetcode.medium;

public class RotateList {
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

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) return head;
    ListNode fast = head, slow = head;
    for (; k > 0; k--) {
      if (fast.next == null) {
        fast = head;
      } else {
        fast = fast.next;
      }
    }
    if (fast == head) return head;
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    ListNode result = slow.next;
    slow.next = null;
    fast.next = head;
    return result;
  }
}
