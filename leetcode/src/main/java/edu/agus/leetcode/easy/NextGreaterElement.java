package edu.agus.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class NextGreaterElement {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Deque<Integer> stack = new ArrayDeque<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int n1 = nums1.length;
    int n2 = nums2.length;
    map.put(nums2[n2 - 1], -1);
    stack.push(nums2[n2 - 1]);
    int[] res = new int[n1];
    for (int i = n2 - 2; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= nums2[i]) stack.poll();
      map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
      stack.push(nums2[i]);
    }
    for (int i = 0; i < n1; i++) {
      res[i] = map.get(nums1[i]);
    }
    return res;
  }
}
