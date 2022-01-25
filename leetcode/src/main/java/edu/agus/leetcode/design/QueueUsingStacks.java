package edu.agus.leetcode.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingStacks {
  class MyQueue {
    private Deque<Integer> left;
    private Deque<Integer> right;

    public MyQueue() {
      left = new ArrayDeque<>();
      right = new ArrayDeque<>();
    }

    public void push(int x) {
      left.push(x);
    }

    private void shift() {
      while (!left.isEmpty()) {
        right.push(left.pop());
      }
    }

    public int pop() {
      if (right.isEmpty()) {
        shift();
      }
      return right.pop();
    }

    public int peek() {
      if (right.isEmpty()) {
        shift();
      }
      return right.peek();
    }

    public boolean empty() {
      return left.isEmpty() && right.isEmpty();
    }
  }
}
