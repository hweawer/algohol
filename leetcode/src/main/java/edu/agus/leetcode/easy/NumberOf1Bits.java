package edu.agus.leetcode.easy;

public class NumberOf1Bits {
  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      count += n & 1;
      n = n >>> 1;
    }
    return count;
  }
}
