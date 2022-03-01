package edu.agus.leetcode.medium;

public class LongestPalindromicSubstring {
  public static String longestPalindrome(String s) {
    String res = "";
    if (s.length() == 1) return s;
    boolean[][] mem = new boolean[s.length()][s.length()];

    for (int i = 0; i < s.length(); i++) {
      mem[i][i] = true;
      res = String.valueOf(s.charAt(i));
    }
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        mem[i][i + 1] = true;
        if (2 > res.length()) {
          res = s.substring(i, i + 2);
        }
      }
    }
    for (int i = 2; i < s.length(); i++) {
      for (int j = 0; j < s.length() - i; j++) {
        mem[j][j + i] = s.charAt(j) == s.charAt(j + i) && mem[j + 1][j + i - 1];
        if (mem[j][j + i]) {
          if (i + 1 > res.length()) {
            res = s.substring(j, j + i + 1);
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("babad"));
  }
}
