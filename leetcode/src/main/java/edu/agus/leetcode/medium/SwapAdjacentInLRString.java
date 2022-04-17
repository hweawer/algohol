package edu.agus.leetcode.medium;

public class SwapAdjacentInLRString {
  public boolean canTransform(String start, String end) {
    int f = 0;
    int s = 0;
    while (f < start.length() || s < end.length()) {
      while (f < start.length() && start.charAt(f) == 'X') f++;
      while (s < end.length() && end.charAt(s) == 'X') s++;
      if (f == start.length() || s == end.length()) return s == end.length() && f == start.length();
      char stChar = start.charAt(f);
      char enChar = end.charAt(s);
      if (stChar != enChar) return false;
      if (stChar == 'R' && f > s) return false;
      if (stChar == 'L' && f < s) return false;
      f++;
      s++;
    }
    return true;
  }
}
