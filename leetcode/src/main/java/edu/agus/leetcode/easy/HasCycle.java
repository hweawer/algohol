package edu.agus.leetcode.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HasCycle {
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public boolean hasCycle(ListNode head) {
    if (head == null) return false;
    ListNode fast = head;
    ListNode slow = new ListNode(0);
    slow.next = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) return true;
    }
    return false;
  }
}
