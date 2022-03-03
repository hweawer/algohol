package edu.agus.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode detectCycle(ListNode head) {
    Set<ListNode> set = new HashSet<>();
    while (head != null) {
      if (set.contains(head)) return head;
      set.add(head);
      head = head.next;
    }
    return null;
  }
}
