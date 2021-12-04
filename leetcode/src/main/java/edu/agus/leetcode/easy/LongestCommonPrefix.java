package edu.agus.leetcode.easy;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    int minl = Integer.MAX_VALUE;
    for (int i = 0; i < strs.length; i++) {
      minl = Math.min(minl, strs[i].length());
    }
    StringBuilder prefix = new StringBuilder();
    for (int i = 0; i < minl; i++) {
      char x = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (strs[j].charAt(i) != x) return prefix.toString();
      }
      prefix.append(x);
    }
    return prefix.toString();
  }

  public static void main(String[] args) {
    LongestCommonPrefix lcp = new LongestCommonPrefix();
    System.out.println(lcp.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
  }
}
