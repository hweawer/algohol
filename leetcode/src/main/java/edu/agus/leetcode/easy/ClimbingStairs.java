package edu.agus.leetcode.easy;

public class ClimbingStairs {

  public int climbStairs(int n) {
    int[] mem = new int[n + 1];
    mem[0] = 1;
    mem[1] = 1;
    for (int i = 2; i < n; i++) {
      mem[i] = mem[i - 1] + mem[i - 2];
    }
    return mem[n];
  }
}
