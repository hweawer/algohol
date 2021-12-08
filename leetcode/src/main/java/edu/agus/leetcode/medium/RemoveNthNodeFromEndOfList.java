package edu.agus.leetcode.medium;

import org.w3c.dom.ls.LSInput;

import java.util.List;

public class RemoveNthNodeFromEndOfList {
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

  public ListNode reverseList(ListNode head) {
    ListNode prev = null, next = null;
    ListNode cur = head;
    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }

  public ListNode reverseListAndRemove(ListNode head, int n) {
    ListNode prev = null, next = null;
    ListNode cur = head;
    int counter = 1;
    while (cur != null) {
      next = cur.next;
      if (counter != n) {
        cur.next = prev;
        prev = cur;
      }
      cur = next;
      counter++;
    }
    return prev;
  }

  // TODO: It is working great, but two pointer solution is more elegant
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode reversed = reverseList(head);
    return reverseListAndRemove(reversed, n);
  }

  // slow and fast pointer solution
  public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

      ListNode slow = head;
      ListNode fast = head;

      // previous element of slow ptr (in linked list to delete current element, prev element pointer is required)
      ListNode prev = null;

      // move fast pointer n step ahead
      while (n-- > 0) {
        fast = fast.next;
      }

      // move both pointer until fast pointer becomes null
      while (fast != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next;
      }
      // if prev is null, it means first element to be deleted (n == size of linked list)
      if (prev == null) {
        // just return pointer to second element
        return head.next;
      }

      // delete element at slow pointer
      prev.next = slow.next;

      return head;
    }

  }
}
