package edu.agus.leetcode.medium;

public class BinaryStringWithSubstringsRepresenting1ToN {
  public boolean queryString(String s, int n) {
    for (int i = 1; i <= n; i++) {
      String binaryString = toBinaryString(i);
      if (!s.contains(binaryString)) return false;
    }
    return true;
  }

  String toBinaryString(int n) {
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      sb.append(n % 2);
      n /= 2;
    }
    return sb.reverse().toString();
  }
}
