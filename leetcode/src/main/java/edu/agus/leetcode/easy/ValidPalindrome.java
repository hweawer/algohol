package edu.agus.leetcode.easy;

public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
        sb.append(s.charAt(i));
      }
    }
    String trimmed = sb.toString().toLowerCase();
    int l = 0;
    int r = trimmed.length() - 1;
    while (l < r) {
      if (trimmed.charAt(l) != trimmed.charAt(r)) return false;
      l++;
      r--;
    }
    return true;
  }
}
