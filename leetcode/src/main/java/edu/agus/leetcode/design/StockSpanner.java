package edu.agus.leetcode.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {
  class Pair {
    int first;
    int second;

    Pair(int f, int s) {
      this.first = f;
      this.second = s;
    }
  }

  private Deque<Pair> stack;

  public StockSpanner() {
    stack = new ArrayDeque<>();
  }

  public int next(int price) {
    int span = 0;
    while (!stack.isEmpty() && stack.peek().first <= price) {
      span += stack.pop().second;
    }
    stack.push(new Pair(price, span));
    return span;
  }
}
