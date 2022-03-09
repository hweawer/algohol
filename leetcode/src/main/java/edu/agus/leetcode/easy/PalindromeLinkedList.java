package edu.agus.leetcode.easy;

public class PalindromeLinkedList {
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

  static ListNode middle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  static ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public static boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    ListNode mid = middle(head);
    ListNode reversed = reverse(mid);
    while (reversed != null) {
      if (head.val != reversed.val) return false;
      head = head.next;
      reversed = reversed.next;
    }
    return true;
  }

  public static void main(String[] args) {
    ListNode n = new ListNode(1);
    n.next = new ListNode(1);
    n.next.next = new ListNode(2);
    n.next.next.next = new ListNode(1);
    isPalindrome(n);
  }
}
