package edu.agus.leetcode.medium;

public class PalindromicSubstrings {
  public boolean isPal(String s, int l, int r) {
    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) return false;
      l++;
      r--;
    }
    return true;
  }

  public int countSubstrings(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j <= i; j++) {
        if (isPal(s, j, i)) count++;
      }
    }
    return count;
  }
}
