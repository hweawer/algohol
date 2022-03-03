package edu.agus.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;

    ListNode tempA = headA;
    ListNode tempB = headB;

    while (tempA != tempB) {
      if (tempA == null) {
        tempA = headB;
      } else {
        tempA = tempA.next;
      }
      if (tempB == null) {
        tempB = headA;
      } else {
        tempB = tempB.next;
      }
    }
    return tempB;
  }
}
