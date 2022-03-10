package edu.agus.leetcode.design;

class FrontMiddleBackQueue {
  static class ListNode {
    ListNode back;
    ListNode front;
    int val;

    ListNode(int v) {
      this.val = v;
    }

    ListNode(int v, ListNode front, ListNode back) {
      this.val = v;
      this.front = front;
      this.back = back;
    }
  }

  ListNode head;
  ListNode tail;
  ListNode middle;
  int size = 0;

  public FrontMiddleBackQueue() {
  }

  private void init(int val) {
    ListNode node = new ListNode(val);
    head = node;
    tail = node;
    middle = node;
    size++;
  }

  public void pushFront(int val) {
    if (size == 0) init(val);
    else {
      ListNode node = new ListNode(val, head, null);
      head.back = node;
      head = node;
      size++;
      if (size % 2 == 0) middle = middle.back;
    }
  }

  public void pushMiddle(int val) {
    if (size == 0) init(val);
    else if (size == 1) pushFront(val);
    else {
      ListNode prev = middle.back;
      ListNode node = new ListNode(val, middle, prev);
      prev.front = node;
      middle.back = node;
      size++;
      if (size % 2 == 0) middle = node;
    }
  }

  public void pushBack(int val) {
    if (size == 0) init(val);
    else {
      ListNode node = new ListNode(val, null, tail);
      tail.front = node;
      tail = node;
      size++;
      if (size % 2 == 1) middle = middle.front;
    }
  }

  private int removeOne() {
    int res = head.val;
    head = null;
    middle = null;
    tail = null;
    size--;
    return res;
  }

  public int popFront() {
    if (size == 0) return -1;
    else if (size == 1) return removeOne();
    else {
      int res = head.val;
      if (size % 2 == 0) middle = middle.front;
      head = head.front;
      head.back = null;
      size--;
      return res;
    }
  }

  public int popMiddle() {
    if (size == 0) return -1;
    else if (size == 1) return removeOne();
    else {
      int res = middle.val;
      ListNode prev = middle.back;
      ListNode next = middle.front;
      prev.front = next;
      next.back = prev;
      if (size % 2 == 0) middle = middle.front;
      else middle = middle.back;
      return res;
    }
  }

  public int popBack() {
    if (size == 0) return -1;
    else if (size == 1) return removeOne();
    else {
      int res = tail.val;
      if (size % 2 == 1) middle = middle.back;
      tail = tail.back;
      tail.front = null;
      size--;
      return res;
    }
  }
}
