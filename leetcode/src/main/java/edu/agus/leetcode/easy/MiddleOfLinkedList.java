package edu.agus.leetcode.easy;

public class MiddleOfLinkedList {
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

  public ListNode middleNode(ListNode head) {
    ListNode copy = head;
    int length = 0;
    while (copy != null) {
      copy = copy.next;
      length++;
    }
    int mid = length / 2;
    while (mid != 0) {
      head = head.next;
      mid--;
    }
    return head;
  }
}
