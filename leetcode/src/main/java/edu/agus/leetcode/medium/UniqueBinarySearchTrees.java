package edu.agus.leetcode.medium;

public class UniqueBinarySearchTrees {
  public int numTrees(int n) {
    int[] mem = new int[n + 1];
    mem[0] = 1;
    mem[1] = 1;

    for (int i = 2; i <= n; i++) {
      int total = 0;
      for (int j = 1; j < i + 1; j++) {
        int left = j - 1;
        int right = i - j;
        total += mem[left] * mem[right];
      }
      mem[i] = total;
    }
    return mem[n];
  }
}
