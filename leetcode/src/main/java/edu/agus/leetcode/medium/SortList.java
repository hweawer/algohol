package edu.agus.leetcode.medium;

public class SortList {
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

  public ListNode getMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    if (prev != null) {
      prev.next = null;
    }
    return slow;
  }

  public ListNode merge(ListNode node1, ListNode node2) {
    ListNode fake = new ListNode();
    ListNode current = fake;
    while (node1 != null && node2 != null) {
      if (node1.val < node2.val) {
        current.next = node1;
        node1 = node1.next;
      } else {
        current.next = node2;
        node2 = node2.next;
      }
      current = current.next;
    }
    while (node1 != null) {
      current.next = node1;
      node1 = node1.next;
      current = current.next;
    }
    while (node2 != null) {
      current.next = node2;
      node2 = node2.next;
      current = current.next;
    }
    return fake.next;
  }

  public ListNode sortList(ListNode head) {
    if (head.next == null) return head;
    ListNode mid = getMid(head);
    return merge(sortList(head), sortList(mid));
  }
}
