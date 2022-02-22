package edu.agus.leetcode.easy;

public class AddStrings {
  public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    StringBuilder n1sb = new StringBuilder(num1).reverse();
    StringBuilder n2sb = new StringBuilder(num2).reverse();
    int n = num1.length();
    int m = num2.length();
    int max = Math.max(n, m);
    int inMemory = 0;
    int i = 0;
    while (i < max) {
      char ni1 = '0';
      if (i < n1sb.length()) {
        ni1 = n1sb.charAt(i);
      }
      char ni2 = '0';
      if (i < n2sb.length()) {
        ni2 = n2sb.charAt(i);
      }

      int res = ni1 - '0' + ni2 - '0' + inMemory;
      int mod = res % 10;
      inMemory = res / 10;
      sb.append(mod);
      i++;
    }
    if (inMemory > 0) sb.append(inMemory);
    return sb.reverse().toString();
  }
}
