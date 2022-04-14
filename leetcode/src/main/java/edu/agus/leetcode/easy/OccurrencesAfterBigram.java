package edu.agus.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram {
  public String[] findOcurrences(String text, String first, String second) {
    List<String> result = new ArrayList();

    int left = 0;
    int right = 1;

    String[] words = text.split(" ");
    if (words.length <= 2) return new String[0];

    while (right < words.length - 1) {
      if (words[left].equals(first) && words[right].equals(second)) {
        result.add(words[right + 1]);
      }
      left++;
      right++;
    }

    String[] ans = new String[result.size()];
    for (int i = 0; i < result.size(); i++) {
      ans[i] = result.get(i);
    }
    return ans;
  }
}
