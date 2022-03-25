package edu.agus.leetcode.medium;

import java.util.*;

public class WordSubsets {
  private static final int L = 26;

  public List<String> wordSubsets(String[] words1, String[] words2) {
    int[] minCounts = new int[L];
    for (String word : words2) {
      int[] counts = count(word);
      for (int i = 0; i < L; i++) {
        minCounts[i] = Math.max(minCounts[i], counts[i]);
      }
    }
    List<String> res = new ArrayList<>();
    for (String word : words1) {
      int[] counts = count(word);
      if (isSubset(minCounts, counts)) {
        res.add(word);
      }
    }
    return res;
  }

  private boolean isSubset(int[] minCounts, int[] counts) {
    for (int i = 0; i < L; i++) {
      if (counts[i] < minCounts[i]) {
        return false;
      }
    }
    return true;
  }

  private int[] count(String word) {
    int[] counts = new int[L];
    for (int i = 0; i < word.length(); i++) {
      int ch = word.charAt(i) - 'a';
      counts[ch]++;
    }
    return counts;
  }
}
