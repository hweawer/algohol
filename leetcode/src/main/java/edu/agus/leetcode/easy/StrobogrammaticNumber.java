package edu.agus.leetcode.easy;

public class StrobogrammaticNumber {
  public boolean isStrobogrammatic(String num) {
    int left = 0;
    int right = num.length() - 1;
    while(left <= right) {
      char lc = num.charAt(left);
      if (lc == '2' || lc == '3' || lc == '4' || lc == '5' || lc == '7') return false;
      char rc = num.charAt(right);
      if (rc == '2' || rc == '3' || rc == '4' || rc == '5' || rc == '7') return false;
      if (lc == '6' && rc != '9') return false;
      if (rc == '9' && lc != '6') return false;
      if (lc == '8' && rc != '8') return false;
      if (rc == '8' && lc != '8') return false;
      if (rc == '0' && lc != '0') return false;
      if (lc == '0' && rc != '0') return false;
      if (lc == '1' && rc != '1') return false;
      if (rc == '1' && lc != '1') return false;
      left++;
      right--;
    }
    return true;
  }
}
