package edu.agus.leetcode.easy;

public class IsPowerOfFour {
  public boolean isPowerOfFour(int n) {
    return (n & (n - 1)) == 0 && (n % 3 == 1);
  }
}
