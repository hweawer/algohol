package edu.agus.leetcode.medium;

import java.util.*;

public class NextGreaterNodeInLinkedList {
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

  public ListNode reverseList(ListNode head) {
    ListNode prev = null, next = null;
    while (head != null) {
      next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public int[] nextLargerNodes(ListNode head) {
    ListNode reversed = reverseList(head);
    List<Integer> list = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();
    while (reversed != null) {
      while (!stack.isEmpty() && stack.peek() <= reversed.val) stack.pop();
      list.add(stack.isEmpty() ? 0 : stack.peek());
      stack.push(reversed.val);
      reversed = reversed.next;
    }
    Collections.reverse(list);
    int[] res = new int[list.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = list.get(i);
    }
    return res;
  }
}
