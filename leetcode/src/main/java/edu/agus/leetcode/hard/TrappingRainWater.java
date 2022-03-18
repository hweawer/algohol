package edu.agus.leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;

public class TrappingRainWater {
  public int trap(int[] height) {
    int n = height.length;
    int ans = 0;
    Deque<Integer> stack = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
        int min = stack.pop();
        if (stack.isEmpty()) break;
        int h = Math.min(height[stack.peek()], height[i]) - height[min];
        int len = i - stack.peek() - 1;
        ans += h * len;
      }
      stack.push(i);
    }
    return ans;
  }
}
