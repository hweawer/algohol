package edu.agus.leetcode.easy;

public class AddBinary {
  public String addBinary(String a, String b) {
    StringBuilder asb = new StringBuilder(a).reverse();
    StringBuilder bsb = new StringBuilder(b).reverse();
    StringBuilder result = new StringBuilder();
    boolean remembered = false;
    int max = Math.max(asb.length(), bsb.length());
    for (int i = 0; i < max; i++) {
      if (i >= asb.length()) {
        asb.append('0');
      } else {
        bsb.append('0');
      }
    }
    for (int i = 0; i < max; i++) {
      if (asb.charAt(i) == '0' && bsb.charAt(i) == '0') {
        result.append(remembered ? '1' : '0');
        remembered = false;
      } else if (asb.charAt(i) == '1' && bsb.charAt(i) == '0') {
        result.append(remembered ? '0' : '1');
      } else if (asb.charAt(i) == '0' && bsb.charAt(i) == '1') {
        result.append(remembered ? '0' : '1');
      } else if (asb.charAt(i) == '1' && bsb.charAt(i) == '1') {
        result.append(remembered ? '1' : '0');
        remembered = true;
      }
    }
    if (remembered) {
      result.append('1');
    }
    return result.reverse().toString();
  }
}
