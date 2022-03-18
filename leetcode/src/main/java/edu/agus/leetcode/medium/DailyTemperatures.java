package edu.agus.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
  public int[] dailyTemperatures(int[] temperatures) {
    Deque<Integer> stack = new ArrayDeque<>();
    int n = temperatures.length;
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        int idx = stack.pop();
        res[idx] = i - idx;
      }
      stack.push(i);
    }
    return res;
  }
}
