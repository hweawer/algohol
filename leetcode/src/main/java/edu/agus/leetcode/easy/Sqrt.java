package edu.agus.leetcode.easy;

public class Sqrt {
  public int mySqrt(int x) {
    int left = 1, right = x / 2;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (mid > x / mid) {
        right = mid - 1;
        continue;
      }
      if ((mid + 1) <= x / (mid + 1)) {
        left = mid + 1;
        continue;
      }
      return mid;
    }
    return x;
  }
}
