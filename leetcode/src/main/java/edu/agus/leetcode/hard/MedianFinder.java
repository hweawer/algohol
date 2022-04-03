package edu.agus.leetcode.hard;

import java.util.PriorityQueue;

public class MedianFinder {
  PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x); // left side
  PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) -> x - y); // right side

  public MedianFinder() {

  }

  public void addNum(int num) {
    maxHeap.add(num);
    minHeap.add(maxHeap.poll());
    if (maxHeap.size() < minHeap.size()) {
      maxHeap.add(minHeap.poll());
    }
  }

  public double findMedian() {
    if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
    else if (maxHeap.size() < minHeap.size()) return minHeap.peek();
    else return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
  }
}
