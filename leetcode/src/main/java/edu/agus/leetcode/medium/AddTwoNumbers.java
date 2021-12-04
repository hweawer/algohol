package edu.agus.leetcode.medium;

public class AddTwoNumbers {
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

  public ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean rank, ListNode res) {
    int it = l1.val + l2.val + (rank ? 1 : 0);
    l1.val = it % 10;
    if (l1.next != null && l2.next != null) {
      return addTwoNumbers(l1.next, l2.next, it >= 10, res);
    } else if (l1.next == null && l2.next != null) {
      l1.next = new ListNode(0);
      return addTwoNumbers(l1.next, l2.next, it >= 10, res);
    } else if (l1.next != null) {
      l2.next = new ListNode(0);
      return addTwoNumbers(l1.next, l2.next, it >= 10, res);
    } else {
      if (it >= 10) {
        l1.next = new ListNode(1);
      }
      return res;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addTwoNumbers(l1, l2, false, l1);
  }
}
