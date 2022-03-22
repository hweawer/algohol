package edu.agus.leetcode.design;

import java.util.LinkedList;

public class MyCircularQueue {
  LinkedList<Integer> queue;
  int size;
  int capacity;

  public MyCircularQueue(int k) {
    capacity = k;
    queue = new LinkedList<>();
  }

  public boolean enQueue(int value) {
    if (size == capacity) return false;
    queue.addFirst(value);
    size++;
    return true;
  }

  public boolean deQueue() {
    if (size == 0) return false;
    queue.removeLast();
    size--;
    return true;
  }

  public int Front() {
    if (size == 0) return -1;
    return queue.getFirst();
  }

  public int Rear() {
    if (size == 0) return -1;
    return queue.getLast();
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == capacity;
  }
}
