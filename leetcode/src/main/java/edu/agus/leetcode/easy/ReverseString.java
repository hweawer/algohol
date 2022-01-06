package edu.agus.leetcode.easy;

public class ReverseString {
  public void swap(char[] str, int i, int j) {
    char temp = str[i];
    str[i] = str[j];
    str[j] = temp;
  }

  public void reverseString(char[] s) {
    int l = 0;
    int r = s.length - 1;
    while (l < r) {
      swap(s, l, r);
      l++;
      r--;
    }
  }
}
