package edu.agus.leetcode.medium;

public class DeleteOperationForTwoStrings {
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] mem = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          mem[i][j] = mem[i - 1][j - 1] + 1;
        } else {
          mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
        }
      }
    }
    int lcs = mem[m][n];
    return m - lcs + n - lcs;
  }
}
