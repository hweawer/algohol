package edu.agus.leetcode.hard;

public class WildCardMatching {
  /*public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();

        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?' || p.charAt(0) == '*');
        if (p.charAt(0) == '*') {
            return isMatch(s, p.substring(1)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }*/

  Boolean[][] mem;
  String word;
  String pattern;

  boolean dp(int i, int j) {
    if (j >= pattern.length()) {
      mem[i][j] = word.length() == i;
      return mem[i][j];
    }

    if (mem[i][j] != null) {
      return mem[i][j];
    }

    boolean firstMatch = i < word.length() && (word.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?' || pattern.charAt(j) == '*');
    if (pattern.charAt(j) == '*') {
      mem[i][j] = dp(i, j + 1) || (firstMatch && dp(i + 1, j));
    } else {
      mem[i][j] = firstMatch && dp(i + 1, j + 1);
    }
    return mem[i][j];
  }

  public boolean isMatch(String s, String p) {
    this.word = s;
    this.pattern = p;
    mem = new Boolean[s.length() + 1][p.length() + 1];
    return dp(0, 0);
  }
}
