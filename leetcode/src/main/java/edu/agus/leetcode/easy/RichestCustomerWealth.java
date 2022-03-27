package edu.agus.leetcode.easy;

public class RichestCustomerWealth {
  public int maximumWealth(int[][] accounts) {
    int max = 0;
    int total = 0;
    for (int i = 0; i < accounts.length; i++) {
      for (int j = 0; j < accounts[0].length; j++) {
        total += accounts[i][j];
      }
      max = Math.max(max, total);
      total = 0;
    }
    return max;
  }
}
