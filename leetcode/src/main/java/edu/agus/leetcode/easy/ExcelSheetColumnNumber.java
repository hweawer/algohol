package edu.agus.leetcode.easy;

public class ExcelSheetColumnNumber {
  public int titleToNumber(String columnTitle) {
    StringBuilder sb = new StringBuilder(columnTitle);
    String reversed = sb.reverse().toString();
    int res = 0;
    for (int i = 0; i < reversed.length(); i++) {
      int c = reversed.charAt(i) - 'A' + 1;
      int pow = c * (int) Math.pow(26, i);
      res += pow;
    }
    return res;
  }
}
