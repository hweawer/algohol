package edu.agus.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumTwinSumOfLinkedList {
  public class ListNode {
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

  ListNode middle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  public int pairSum(ListNode head) {
    ListNode mid = middle(head);
    Deque<ListNode> stack = new ArrayDeque<>();
    while (mid != null) {
      stack.push(mid);
      mid = mid.next;
    }
    int res = 0;
    while(!stack.isEmpty()) {
      int t1 = head.val;
      int t2 = stack.pop().val;
      res = Math.max(res, t1 + t2);
      head = head.next;
    }
    return res;
  }
}
