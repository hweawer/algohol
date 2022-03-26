package edu.agus.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {
  Queue<Integer> window = new LinkedList();
  int size;
  int sum = 0;

  public MovingAverageFromDataStream(int size) {
    this.size = size;
  }

  public double next(int val) {
    if (window.size() < size) {
      window.add(val);
      sum += val;
    } else {
      int front = window.poll();
      sum -= front;
      window.add(val);
      sum += val;
    }
    return (double) sum / window.size();
  }
}
