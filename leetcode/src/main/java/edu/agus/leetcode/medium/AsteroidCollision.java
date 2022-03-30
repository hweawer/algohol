package edu.agus.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
  public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int cur : asteroids) {
      if (cur > 0) {
        stack.push(cur);
      } else {
        while (!stack.isEmpty() && stack.peek() > 0 && -cur > stack.peek()) {
          stack.pop();
        }

        if (stack.isEmpty() || stack.peek() < 0) {
          stack.push(cur);
        } else if (stack.peek() == -cur) {
          stack.pop();
        }
      }

    }
    int size = stack.size();
    int[] res = new int[size];
    for (int i = size - 1; i >= 0; i--) {
      res[i] = stack.pop();
    }
    return res;
  }
}
