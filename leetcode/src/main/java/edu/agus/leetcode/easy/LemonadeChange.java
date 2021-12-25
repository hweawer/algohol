package edu.agus.leetcode.easy;

public class LemonadeChange {
  public boolean lemonadeChange(int[] bills) {
    int i = 0;
    boolean canGive = true;
    int fives = 0;
    int tens = 0;

    while (i != bills.length && canGive) {
      int current = bills[i];
      if (current == 5) {
        fives++;
      }
      if (current == 10) {
        if (fives == 0) {
          canGive = false;
        } else {
          fives--;
          tens++;
        }
      }
      if (current == 20) {
        if (fives >= 1 && tens >= 1) {
          fives--;
          tens--;
        } else if (fives >= 3) {
          fives -= 3;
        } else {
          canGive = false;
        }
      }
      i++;
    }
    return canGive;
  }
}
