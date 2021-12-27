package edu.agus.leetcode.easy;

public class Maximum69Number {

  public int maximum69Number(int num) {
    int pow = (int) Math.log10(num);
    while (pow >= 0) {
      int div = (int) Math.pow(10, pow);
      int z = (num / div) % 10;
      if (z == 6) {
        num = ((num / div) + 3) * div + num % div;
        return num;
      }
      pow--;
    }
    return num;
  }
}
