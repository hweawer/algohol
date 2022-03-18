package edu.agus.leetcode.hard;

import java.util.*;

public class LargestRectangleInAHistogram {
  public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    if (n == 1) return heights[0];
    Deque<Integer> stack = new LinkedList<>();
    int res = 0;
    int len = 0;
    int height = 0;
    List<Integer> list = new ArrayList<>();
    for (int j : heights) list.add(j);
    list.add(0);
    for (int i = 0; i < list.size(); i++) {
      while (!stack.isEmpty() && list.get(stack.peek()) > list.get(i)) {
        height = list.get(stack.pop());
        if (stack.isEmpty()) len = i;
        else len = i - stack.peek() - 1;
        res = Math.max(res, len * height);
      }
      stack.push(i);
    }
    return res;
  }
}
