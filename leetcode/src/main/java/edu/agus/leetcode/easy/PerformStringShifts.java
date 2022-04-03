package edu.agus.leetcode.easy;

public class PerformStringShifts {
  int[] resultingShift(int[][] shift, int n) {
    int left = 0;
    int right = 0;
    for (int[] s : shift) {
      if (s[0] == 0) left += s[1];
      else right += s[1];
    }
    left = left % n;
    right = right % n;
    if (left < right) {
      return new int[]{1, right - left};
    }
    return new int[]{0, left - right};
  }

  public String stringShift(String s, int[][] shift) {
    int[] finalShift = resultingShift(shift, s.length());
    if (finalShift[1] == 0) return s;
    if (finalShift[0] == 0) {
      String left = s.substring(0, finalShift[1]);
      String right = s.substring(finalShift[1]);
      return right + left;
    } else {
      String left = s.substring(0, s.length() - finalShift[1]);
      String right = s.substring(s.length() - finalShift[1]);
      return right + left;
    }
  }
}
