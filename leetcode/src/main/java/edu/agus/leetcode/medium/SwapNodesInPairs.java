package edu.agus.leetcode.medium;

public class SwapNodesInPairs {
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

  public ListNode swapPairs(ListNode head) {
    if (head == null) return null;
    int i = 0;
    ListNode fakeNode = new ListNode();
    fakeNode.next = head;
    ListNode prev = fakeNode;
    ListNode next = head.next;
    while (next != null) {
      if (i % 2 == 0) {
        head.next = next.next;
        prev.next = next;
        next.next = head;
        prev = next;
        next = head.next;
      } else {
        prev = head;
        head = next;
        next = next.next;
      }
      i++;
    }
    return fakeNode.next;
  }
}
