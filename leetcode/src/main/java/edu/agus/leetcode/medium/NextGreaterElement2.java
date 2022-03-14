package edu.agus.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterElement2 {
  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    Deque<Integer> st = new ArrayDeque<>();
    for (int i = 2 * n - 1; i >= 0; i--) {
      while (!st.isEmpty() && st.peek() <= nums[i % n]) st.poll();
      res[i % n] = st.isEmpty() ? -1 : st.peek();
      st.push(nums[i % n]);
    }
    return res;
  }
}
