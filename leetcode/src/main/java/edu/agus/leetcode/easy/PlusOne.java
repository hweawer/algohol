package edu.agus.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusOne {
  public int[] plusOne(int[] digits) {
    List<Integer> res = new ArrayList<>();

    int inMemory = 0;
    int resLast = digits[digits.length - 1] + 1;
    if (resLast >= 10) inMemory = 1;
    res.add(resLast % 10);
    for (int i = digits.length - 2; i >= 0; i--) {
      if (inMemory == 0) res.add(digits[i]);
      else {
        int resIt = digits[i] + inMemory;
        if (resIt < 10) inMemory = 0;
        res.add(resIt % 10);
      }
    }
    if (inMemory != 0) res.add(inMemory);

    Collections.reverse(res);
    int[] ans = new int[res.size()];
    for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
    return ans;
  }
}
