package edu.agus.leetcode.medium;

public class InterleavingString {
  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) return false;
    int n = s1.length();
    int m = s2.length();

    boolean[][] mem = new boolean[n + 1][m + 1];
    mem[n][m] = true;

    for (int i = n; i >= 0; i--) {
      for (int j = m; j >= 0; j--) {
        if (j < m && s2.charAt(j) == s3.charAt(i + j) && mem[i][j + 1])
          mem[i][j] = true;
        if (i < n && s1.charAt(i) == s3.charAt(i + j) && mem[i + 1][j])
          mem[i][j] = true;
      }
    }
    return mem[0][0];
  }

}
