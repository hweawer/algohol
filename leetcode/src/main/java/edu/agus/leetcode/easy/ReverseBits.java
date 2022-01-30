package edu.agus.leetcode.easy;

public class ReverseBits {
  public int reverseBits(int n) {
    int res = 0;
    int last;
    for (int i = 0; i < 32; i++) {
      last = n & 1;
      res = res << 1;
      res = res | last;
      n = n >>> 1;
    }
    return res;
  }
}
