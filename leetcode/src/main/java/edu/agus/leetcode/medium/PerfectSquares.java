package edu.agus.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PerfectSquares {
  boolean isPerfectSquare(int x) {
    return (Math.sqrt(x) % 1) == 0;
  }

  public int numSquares(int n) {
    int[] mem = new int[n + 1];
    Arrays.fill(mem, Integer.MAX_VALUE);
    mem[0] = 0;
    Set<Integer> squares = new HashSet();
    for (int i = 1; i < n + 1; i++) {
      if (isPerfectSquare(i)) {
        mem[i] = 1;
        squares.add(i);
      }
    }
    for (int i = 2; i < n + 1; i++) {
      for (int sq : squares) {
        if (!squares.contains(i) && i - sq >= 0) {
          mem[i] = Math.min(mem[i], mem[i - sq] + 1);
        }
      }
    }
    return mem[n];
  }
}
