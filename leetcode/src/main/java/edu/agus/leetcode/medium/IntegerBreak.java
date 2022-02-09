package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak {
  public int integerBreak(int n) {
    Map<Integer, Integer> dp = new HashMap<>();
    dp.put(1, 1);
    for (int num = 2; num <= n; num++) {
      if (num == n) dp.put(num, 0);
      else dp.put(num, num);
      for (int i = 1; i < num; i++) {
        int product = dp.get(i) * dp.get(num - i);
        dp.put(num, Math.max(dp.get(num), product));
      }
    }
    return dp.get(n);
  }
}
