package edu.agus.leetcode.easy;

public class ReverseWords3 {
  public String reverse(String x) {
    StringBuilder sb = new StringBuilder();
    for (int i = x.length() - 1; i >= 0; i--) {
      sb.append(x.charAt(i));
    }
    return sb.toString();
  }


  public String reverseWords(String s) {
    String[] sp = s.split(" ");
    StringBuilder res = new StringBuilder();
    for (String word : sp) {
      res.append(reverse(word)).append(" ");
    }
    return res.toString().trim();
  }
}
