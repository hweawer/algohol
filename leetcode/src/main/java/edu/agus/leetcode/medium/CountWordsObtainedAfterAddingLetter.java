package edu.agus.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class CountWordsObtainedAfterAddingLetter {
  int generateMask(String word) {
    int res = 0;
    for (char c : word.toCharArray()) res = res | (1 << c - 'a');
    return res;
  }

  public int wordCount(String[] startWords, String[] targetWords) {
    Set<Integer> masks = new HashSet();
    for (String w : startWords) {
      int mask = generateMask(w);
      masks.add(mask);
    }

    int res = 0;
    for (String target : targetWords) {
      int mask = generateMask(target);

      for (char c : target.toCharArray()) {
        int reduce = mask ^ (1 << c - 'a');
        if (masks.contains(reduce)) {
          res++;
          break;
        }
      }
    }
    return res;
  }
}
