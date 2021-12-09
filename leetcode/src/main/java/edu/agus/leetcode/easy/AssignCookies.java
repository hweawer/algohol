package edu.agus.leetcode.easy;

import java.util.Arrays;

public class AssignCookies {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int res = 0;
    for (int i = 0, j = 0; i < g.length && j < s.length; ) {
      if (g[i] <= s[j]) {
        i++;
        j++;
        res++;
      } else j++;
    }
    return res;
  }
}
