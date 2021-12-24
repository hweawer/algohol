package edu.agus.leetcode.easy;

public class LargestOddNumberInString {
  public String largestOddNumber(String num) {
    String res = "";
    for (int i = 0; i < num.length(); i++) {
      char c = num.charAt(i);
      if (c == '1' || c == '3' || c == '5' || c == '7' || c == '9') {
        res = num.substring(0, i + 1);
      }
    }
    return res;
  }
}
