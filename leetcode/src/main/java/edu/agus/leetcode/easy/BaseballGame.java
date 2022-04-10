package edu.agus.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class BaseballGame {
  public int calPoints(String[] ops) {
    Deque<Integer> stack = new ArrayDeque();
    for (String s : ops) {
      if (s.equals("C")) {
        stack.pop();
      } else if (s.equals("D")) {
        stack.push(2 * stack.peek());
      } else if (s.equals("+")) {
        int f = stack.pop();
        int n = f + stack.peek();
        stack.push(f);
        stack.push(n);
      } else {
        stack.push(Integer.parseInt(s));
      }
    }
    int total = 0;
    while (!stack.isEmpty()) {
      total += stack.pop();
    }
    return total;
  }
}
