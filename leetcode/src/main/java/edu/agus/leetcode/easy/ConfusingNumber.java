package edu.agus.leetcode.easy;

public class ConfusingNumber {
  public boolean confusingNumber(int n) {
    int copy = n;
    int log = (int) Math.log10(n);
    int mult = (int) Math.pow(10, log);
    int acc = 0;
    while(copy > 0) {
      int last = copy % 10;
      if (last == 6) {
        last = 9;
      } else if (last == 9) {
        last = 6;
      }
      if (last != 6 && last != 9 && last != 0 && last != 1 && last != 8) return false;
      acc += last * mult;
      mult /= 10;
      copy /= 10;
    }
    return acc != n;
  }
}
