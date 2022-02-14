package edu.agus.leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] mem = new boolean[n + 1];
    mem[n] = true;
    Set<String> set = new HashSet<>(wordDict);
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        if (set.contains(s.substring(i, j + 1)) && mem[j + 1]) {
          mem[i] = true;
          break;
        }
      }
    }
    return mem[0];
  }
}
