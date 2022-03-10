package edu.agus.leetcode.medium;

public class MergeNodesInBetweenZeroes {
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

  public ListNode mergeNodes(ListNode head) {
    int acc = 0;
    head = head.next;
    ListNode fake = new ListNode();
    ListNode cur = fake;
    while (head != null) {
      acc += head.val;
      if (head.val == 0) {
        cur.next = new ListNode(acc);
        acc = 0;
        cur = cur.next;
      }
      head = head.next;
    }
    return fake.next;
  }
}
