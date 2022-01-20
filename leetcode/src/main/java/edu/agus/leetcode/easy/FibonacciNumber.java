package edu.agus.leetcode.easy;

public class FibonacciNumber {
  public int fib(int n) {
    int prev = 0;
    int current = 1;
    if (n == 0) return prev;
    if (n == 1) return current;
    else {
      for (int i = 1; i < n; i++) {
        int temp = current;
        current = current + prev;
        prev = temp;
      }
    }
    return current;
  }
}
