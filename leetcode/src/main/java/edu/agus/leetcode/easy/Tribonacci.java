package edu.agus.leetcode.easy;

public class Tribonacci {
  public int tribonacci(int n) {
    int prev1 = 0;
    int prev2 = 1;
    int current = 1;
    if (n == 0) return prev1;
    if (n == 1 || n == 2) return current;
    for (int i = 2; i < n; i++) {
      int temp1 = current;
      int temp2 = prev2;
      current = current + prev1 + prev2;
      prev2 = temp1;
      prev1 = temp2;
    }
    return current;
  }
}
