package edu.agus.leetcode.design;

import java.util.ArrayList;
import java.util.List;

public class StackWithIncrement {
  class CustomStack {
    final int MAX_SIZE;
    List<Integer> stack;

    public CustomStack(int maxSize) {
      MAX_SIZE = maxSize;
      stack = new ArrayList<>(maxSize);
    }

    public void push(int x) {
      if (stack.size() != MAX_SIZE) {
        stack.add(x);
      }
    }

    public int pop() {
      if (stack.isEmpty()) return -1;
      else {
        int e = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return e;
      }
    }

    public void increment(int k, int val) {
      int border = Math.min(k, stack.size());
      for (int i = 0; i < border; i++) {
        int e = stack.get(i);
        stack.set(i, e + val);
      }
    }
  }
}
