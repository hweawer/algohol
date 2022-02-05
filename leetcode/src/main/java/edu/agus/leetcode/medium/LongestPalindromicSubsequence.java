package edu.agus.leetcode.medium;

public class LongestPalindromicSubsequence {
  public int longestPalindromeSubseq(String s) {
    String rev = new StringBuilder(s).reverse().toString();
    int n = s.length();
    int[][] mem = new int[n + 1][n + 1];

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (s.charAt(i - 1) == rev.charAt(j - 1)) {
          mem[i][j] = 1 + mem[i - 1][j - 1];
        } else {
          mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
        }
      }
    }
    return mem[n][n];
  }
}
