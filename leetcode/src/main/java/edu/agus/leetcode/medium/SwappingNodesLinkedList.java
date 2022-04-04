package edu.agus.leetcode.medium;

public class SwappingNodesLinkedList {
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

  public ListNode swapNodes(ListNode head, int k) {
    ListNode fast = head;
    int idx = 1;
    while (idx < k) {
      fast = fast.next;
      idx++;
    }
    ListNode first = fast;
    ListNode slow = head;
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    int temp = slow.val;
    slow.val = first.val;
    first.val = temp;
    return head;
  }
}
