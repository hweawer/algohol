package edu.agus.leetcode.medium;

public class LongestCommonSubsequence {
  public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[][] mem = new int[m + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (text1.charAt(j - 1) == text2.charAt(i - 1)) {
          mem[j][i] = 1 + mem[j - 1][i - 1];
        } else {
          mem[j][i] = Math.max(mem[j][i - 1], mem[j - 1][i]);
        }
      }
    }
    return mem[m][n];
  }
}
