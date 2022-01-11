package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
  List<String> result = new ArrayList<>();

  public void backtracking(String prefix, String suffix) {
    if (suffix.length() == 0) {
      result.add(prefix);
    } else {
      char first = suffix.charAt(0);
      String sub = suffix.substring(1);
      if (Character.isAlphabetic(first)) {
        backtracking(prefix + Character.toLowerCase(first), sub);
        backtracking(prefix + Character.toUpperCase(first), sub);
      } else {
        backtracking(prefix + first, sub);
      }
    }
  }

  public List<String> letterCasePermutation(String s) {
    backtracking("", s.toLowerCase());
    return result;
  }
}
