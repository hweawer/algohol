package edu.agus.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ReorderList {
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

  public void reorderList(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    if (slow == null) return;
    ListNode mid = slow.next;
    slow.next = null;
    Deque<ListNode> stack = new ArrayDeque<>();
    while (mid != null) {
      stack.push(mid);
      mid = mid.next;
    }
    ListNode next;
    while (head != null && !stack.isEmpty()) {
      next = head.next;
      head.next = stack.pop();
      head.next.next = next;
      head = next;
    }
  }
}
