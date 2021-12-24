package edu.agus.leetcode.easy;

public class DIStringMatch {
  public int[] diStringMatch(String s) {
    int n = s.length();
    int[] result = new int[n + 1];
    int[] asc = new int[n + 1];
    int[] desc = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      asc[i] = i;
      desc[i] = n - i;
    }
    int ascI = 0;
    int descI = 0;
    char c = 'D';

    for (int i = 0; i <= n; i++) {
      if (i != n) {
        c = s.charAt(i);
      }
      if (c == 'I') {
        result[i] = asc[ascI];
        ascI++;
      } else {
        result[i] = desc[descI];
        descI++;
      }
    }
    return result;
  }
}
