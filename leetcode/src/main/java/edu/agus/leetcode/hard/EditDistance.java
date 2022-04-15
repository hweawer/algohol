package edu.agus.leetcode.hard;

import java.util.Arrays;

public class EditDistance {
  String word1;
  String word2;
  int[][] mem;

  int dfs(int i, int j) {
    if (mem[i][j] != Integer.MAX_VALUE) return mem[i][j];
    else if (i >= word1.length() && j < word2.length()) mem[i][j] = 1 + dfs(i, j + 1);
    else if (i < word1.length() && j >= word2.length()) mem[i][j] = 1 + dfs(i + 1, j);
    else if (word1.charAt(i) == word2.charAt(j)) mem[i][j] = dfs(i + 1, j + 1);
    else {
      int insert = dfs(i, j + 1);
      int delete = dfs(i + 1, j);
      int replace = dfs(i + 1, j + 1);
      mem[i][j] = Math.min(Math.min(insert, delete), replace) + 1;
    }
    return mem[i][j];
  }

  public int minDistance(String word1, String word2) {
    this.word1 = word1;
    this.word2 = word2;
    mem = new int[word1.length() + 1][word2.length() + 1];
    for (int[] arr : mem) {
      Arrays.fill(arr, Integer.MAX_VALUE);
    }
    mem[word1.length()][word2.length()] = 0;
    return dfs(0, 0);
  }
}
