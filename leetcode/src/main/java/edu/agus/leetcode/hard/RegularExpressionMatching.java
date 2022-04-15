package edu.agus.leetcode.hard;

public class RegularExpressionMatching {
  String text;
  String pattern;
  Boolean[][] mem;

  private boolean dp(int i, int j) {
    if (j >= pattern.length()) {
      mem[i][j] = text.length() == i;
      return mem[i][j];
    }
    if (mem[i][j] != null) {
      return mem[i][j];
    }

    boolean compareFirst = i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
    if (j < pattern.length() - 1 && pattern.charAt(j + 1) == '*') {
      mem[i][j] = dp(i, j + 2) || (compareFirst && dp(i + 1, j));
    } else {
      mem[i][j] = compareFirst && dp(i + 1, j + 1);
    }
    return mem[i][j];
  }

  public boolean isMatch(String text, String pattern) {
    this.text = text;
    this.pattern = pattern;
    mem = new Boolean[text.length() + 1][pattern.length() + 1];
    return dp(0, 0);
  }
}
