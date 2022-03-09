package edu.agus.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
  public boolean isHappy(int n) {
    Set<Integer> numset = new HashSet<>();
    while (!numset.contains(n) && n != 1) {
      numset.add(n);
      int sum = 0;
      for (; n > 0; n /= 10)
        sum += ((n % 10) * (n % 10));
      n = sum;
    }
    return n == 1;
  }
}
