package edu.agus.leetcode.easy;

public class RemoveLinkedListElements {
  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode removeElements(ListNode head, int val) {
    ListNode fake = new ListNode(0);
    ListNode prev = fake;
    fake.next = head;
    while (head != null) {
      if (head.val == val) {
        prev.next = head.next;
      } else {
        prev = head;
      }
      head = head.next;
    }
    return fake.next;
  }
}
