package edu.agus.leetcode.design;

import java.util.HashSet;
import java.util.Set;

public class PhoneDirectory {
  Set<Integer> pool;

  public PhoneDirectory(int maxNumbers) {
    pool = new HashSet<>();
    for (int i = 0; i < maxNumbers; i++) {
      pool.add(i);
    }
  }

  public int get() {
    if (pool.isEmpty()) {
      return -1;
    }

    int num = pool.iterator().next();
    pool.remove(num);
    return num;
  }

  public boolean check(int number) {
    if (pool.contains(number)) {
      return true;
    }

    return false;
  }

  public void release(int number) {
    pool.add(number);
  }
}
