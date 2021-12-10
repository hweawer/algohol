package edu.agus.leetcode.medium;

public class PartitionList {
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

  public ListNode partition(ListNode head, int x) {
    if (head == null) return head;
    ListNode lessHead = new ListNode();
    ListNode fakeNode = lessHead;
    lessHead.next = head;
    while (lessHead.next != null && lessHead.next.val < x) {
      lessHead = lessHead.next;
    }
    if (lessHead.next == null) return head;
    ListNode current = lessHead.next;
    ListNode prev = null;
    while (current != null) {
      if (current.val < x) {
        prev.next = current.next;
        current.next = lessHead.next;
        lessHead.next = current;
        lessHead = lessHead.next;
      }
      prev = current;
      current = current.next;
    }
    return fakeNode.next;
  }

}
