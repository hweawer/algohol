package edu.agus.leetcode.hard;

import java.util.*;

public class SlidingWindowMedian {
  class SlidingWindowMedianI {
    // maxHeap.size >= minHeap
    //TODO: THIS PROBLEM IS ULTRA EXPLOIT OF OVERFLOWS AND COMAPRATORS
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    SlidingWindowMedianI() {

    }

    void add(int x) {
      maxHeap.add(x);
      minHeap.add(maxHeap.poll());
      if (maxHeap.size() < minHeap.size()) {
        maxHeap.add(minHeap.poll());
      }
    }

    void remove(int x) {
      if (!maxHeap.remove(x)) {
        minHeap.remove(x);
      }
      if (maxHeap.size() < minHeap.size()) {
        maxHeap.add(minHeap.poll());
      }
      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.add(maxHeap.poll());
      }
    }

    double median() {
      if (maxHeap.size() > minHeap.size()) {
        return maxHeap.peek();
      }
      return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
    }
  }

  public double[] medianSlidingWindow(int[] nums, int k) {
    List<Double> res = new ArrayList();
    SlidingWindowMedianI swm = new SlidingWindowMedianI();
    for (int i = 0; i < k; i++) {
      swm.add(nums[i]);
    }
    res.add(swm.median());
    for (int left = 1, right = k; right < nums.length; right++, left++) {
      swm.remove(nums[left - 1]);
      swm.add(nums[right]);
      res.add(swm.median());
    }
    double[] ans = new double[res.size()];
    for (int i = 0; i < res.size(); i++) {
      ans[i] = res.get(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    SlidingWindowMedian swm = new SlidingWindowMedian();
    int[] arr = new int[]{-2147483648, -2147483648, 2147483647, -2147483648, 1, 3, -2147483648, -100, 8, 17, 22, -2147483648, -2147483648, 2147483647, 2147483647, 2147483647, 2147483647, -2147483648, 2147483647, -2147483648};
    int k = 6;
    swm.medianSlidingWindow(arr, k);
  }
}
