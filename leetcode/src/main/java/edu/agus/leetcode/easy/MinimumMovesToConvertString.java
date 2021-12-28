package edu.agus.leetcode.easy;

public class MinimumMovesToConvertString {
  public int minimumMoves(String s) {
    int result = 0;
    int l = -3;
    int i = 0;
    while (i < s.length()) {
      if (s.charAt(i) == 'X' && l + 2 < i) {
        result++;
        l = i;
      }
      i++;
    }
    return result;
  }
}
