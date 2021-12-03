package edu.agus.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
  static Map<Character, Integer> dict = new HashMap<>();

  static {
    dict.put('I', 1);
    dict.put('V', 5);
    dict.put('X', 10);
    dict.put('L', 50);
    dict.put('C', 100);
    dict.put('D', 500);
    dict.put('M', 1000);
  }

  public int romanToInt(String s) {
    int res = 0;
    int prev = Integer.MAX_VALUE;
    for (int i = 0; i < s.length(); i++) {
      int current = dict.get(s.charAt(i));
      if (prev < current) {
        res = res + current - prev * 2;
      } else {
        res += current;
      }
      prev = current;
    }
    return res;
  }
}
