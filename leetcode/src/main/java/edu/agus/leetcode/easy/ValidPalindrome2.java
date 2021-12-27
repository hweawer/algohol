package edu.agus.leetcode.easy;

public class ValidPalindrome2 {
  public boolean rec(String s, int l, int r, boolean wasDeleted) {
    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) {
        if (wasDeleted) return false;

        return rec(s, l + 1, r, true) || rec(s, l, r - 1, true);
      }
      l++;
      r--;
    }
    return true;
  }

  public boolean validPalindrome(String s) {
    return rec(s, 0, s.length() - 1, false);
  }
}
