package edu.agus.leetcode.medium;

public class IntegerReplacement {
  public int integerReplacement(int n) {
    int step = 0;
    //todo: its a hack
    long c = n;
    while (c > 1) {
      if (c % 2 == 0) c /= 2;
      else {
        long det = ((c - 1) / 2);
        if (det % 2 == 0 || det == 1) c--;
        else c++;
      }
      step++;
    }
    return step;
  }
}
