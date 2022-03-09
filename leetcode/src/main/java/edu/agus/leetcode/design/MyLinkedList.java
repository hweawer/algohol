package edu.agus.leetcode.design;

class MyLinkedList {
  static class Node {
    int val;
    Node next;

    public Node(int v) {
      this.val = v;
    }
  }

  Node head;
  Node tail;
  int size = 0;

  public MyLinkedList() {
  }

  public int get(int index) {
    if (index >= size) return -1;
    Node c = head;
    int i = 0;
    while (i < index) {
      c = c.next;
      i++;
    }
    return c.val;
  }

  public void addAtHead(int val) {
    Node newNode = new Node(val);
    if (head != null) {
      newNode.next = head;
    }
    head = newNode;
    if (tail == null) {
      tail = newNode;
    }
    size++;
  }

  public void addAtTail(int val) {
    Node newNode = new Node(val);
    if (head == null) {
      head = newNode;
    }
    if (tail != null) {
      tail.next = newNode;
    }
    tail = newNode;
    size++;
  }

  public void addAtIndex(int index, int val) {
    if (index == size) addAtTail(val);
    else if (index == 0) addAtHead(val);
    else if (index > size) return;
    else {
      int i = 0;
      Node c = head;
      while (i < index - 1) {
        i++;
        c = c.next;
      }
      Node next = c.next;
      c.next = new Node(val);
      c.next.next = next;
      size++;
    }
  }

  public void deleteAtIndex(int index) {
    if (index >= size) return;
    if (size == 1) {
      head = null;
      tail = null;
    } else if (index == 0) {
      head = head.next;
    } else {
      int i = 0;
      Node c = head;
      while (i < index - 1) {
        i++;
        c = c.next;
      }
      c.next = c.next.next;
      if (i == size - 1) {
        tail = c.next;
      }
    }
    size--;
  }
}
