package edu.agus.leetcode.easy;

public class CountingBits {
  public int numberOfOnes(int x) {
    int count = 0;
    while (x != 0) {
      count += x & 1;
      x = x >>> 1;
    }
    return count;
  }

  public int[] countBits(int n) {
    int[] result = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      result[i] = numberOfOnes(i);
    }
    return result;
  }
}
