package edu.agus.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MaxStack {
  Deque<Integer> stack = new ArrayDeque<>();
  Deque<Integer> max = new ArrayDeque<>();

  public MaxStack() {
  }

  public void push(int x) {
    stack.push(x);
    if (max.isEmpty() || max.peek() <= x) {
      max.push(x);
    } else {
      max.push(max.peek());
    }
  }

  public int pop() {
    max.pop();
    return stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int peekMax() {
    return max.peek();
  }

  public int popMax() {
    int max = peekMax();
    Deque<Integer> buffer = new ArrayDeque<>();
    while (top() != max) buffer.push(pop());
    pop();
    while (!buffer.isEmpty()) push(buffer.pop());
    return max;
  }
}
