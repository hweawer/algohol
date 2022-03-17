package edu.agus.leetcode.medium;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
  StringBuilder sb = new StringBuilder();
  List<String> res = new ArrayList<>();
  int n;

  Map<Character, char[]> dict = new HashMap<>();

  {
    {
      dict.put('2', new char[]{'a', 'b', 'c'});
      dict.put('3', new char[]{'d', 'e', 'f'});
      dict.put('4', new char[]{'g', 'h', 'i'});
      dict.put('5', new char[]{'j', 'k', 'l'});
      dict.put('6', new char[]{'m', 'n', 'o'});
      dict.put('7', new char[]{'p', 'q', 'r', 's'});
      dict.put('8', new char[]{'t', 'u', 'v'});
      dict.put('9', new char[]{'w', 'x', 'y', 'z'});
    }
  }

  public void backtracking(int i, String digits) {
    if (i == n) res.add(sb.toString());
    else {
      char c = digits.charAt(i);
      char[] letters = dict.get(c);
      for (char letter : letters) {
        sb.append(letter);
        backtracking(i + 1, digits);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }

  public List<String> letterCombinations(String digits) {
    n = digits.length();
    if (n == 0) return new ArrayList<>();
    backtracking(0, digits);
    return res;
  }
}
