package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

  class ListNode {
    ListNode prev;
    ListNode next;
    int key;
    int val;

    ListNode(int key, int value) {
      this.key = key;
      this.val = value;
    }
  }

  class DoubleLinkedList {
    ListNode head = null;
    ListNode tail = null;
    int size = 0;

    DoubleLinkedList() {
    }

    void add(ListNode node) {
      if (head == null && tail == null) {
        head = node;
        tail = node;
      } else {
        node.prev = tail;
        tail.next = node;
        tail = node;
      }
      size++;
    }

    void remove(ListNode node) {
      if (node == null || size == 0) return;
      if (size == 1) {
        head = null;
        tail = null;
      } else if (tail.key == node.key) {
        tail.prev.next = null;
        tail = tail.prev;
      } else if (head.key == node.key) {
        head.next.prev = null;
        head = head.next;
      } else {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
      }
      size--;
    }

    void removeFirst() {
      remove(head);
    }
  }

  Map<Integer, ListNode> dict = new HashMap();
  DoubleLinkedList list = new DoubleLinkedList();
  int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    ListNode node = dict.get(key);
    if (node == null) return -1;
    list.remove(node);
    list.add(node);
    return node.val;
  }

  public void put(int key, int value) {
    if (!dict.containsKey(key) && dict.size() == capacity) {
      ListNode head = list.head;
      dict.remove(head.key);
      list.removeFirst();
    } else if (dict.containsKey(key)) {
      list.remove(dict.get(key));
    }
    ListNode node = new ListNode(key, value);
    dict.put(key, node);
    list.add(node);
  }
}
