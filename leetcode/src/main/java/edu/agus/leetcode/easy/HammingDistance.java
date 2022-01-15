package edu.agus.leetcode.easy;

public class HammingDistance {
  public int hamming(int x) {
    int res = 0;
    while (x != 0) {
      res += x % 2;
      x = x >>> 1;
    }
    return res;
  }

  public int hammingDistance(int x, int y) {
    return hamming(x & y);
  }
}
