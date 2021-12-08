package edu.agus.leetcode.easy;

public class MergeTwoSortedLists {
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

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode fake = new ListNode();
    ListNode res = fake;
    while (list1 != list2) {
      if (list1 == null) {
        res.next = list2;
        res = res.next;
        list2 = list2.next;
      } else if (list2 == null) {
        res.next = list1;
        res = res.next;
        list1 = list1.next;
      } else if (list1.val == list2.val || list1.val < list2.val) {
        res.next = list1;
        res = res.next;
        list1 = list1.next;
      } else {
        res.next = list2;
        res = res.next;
        list2 = list2.next;
      }
    }
    return fake.next;
  }
}
