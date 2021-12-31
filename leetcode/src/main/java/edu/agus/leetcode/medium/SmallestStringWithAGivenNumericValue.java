package edu.agus.leetcode.medium;

public class SmallestStringWithAGivenNumericValue {
  public String getSmallestString(int n, int k) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append('a');
      k--;
    }
    int i = n - 1;
    while (k > 0) {
      if (k <= 25) {
        sb.setCharAt(i, (char) (sb.charAt(i) + k));
        k = 0;
      } else {
        sb.setCharAt(i, 'z');
        k -= 25;
      }
      i--;
    }
    return sb.toString();
  }
}
