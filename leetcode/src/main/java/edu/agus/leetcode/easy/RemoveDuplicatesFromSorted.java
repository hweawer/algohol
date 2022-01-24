package edu.agus.leetcode.easy;

public class RemoveDuplicatesFromSorted {
  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode deleteDuplicates(ListNode head) {
    ListNode fake = new ListNode(0);
    fake.next = head;
    ListNode prev = fake;
    while (head != null && head.next != null) {
      if (head.val == head.next.val) {
        prev.next = head.next;
      } else {
        prev = head;
      }
      head = head.next;
    }
    return fake.next;
  }
}
