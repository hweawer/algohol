package edu.agus.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
  int n;

  public List<String> fullJustify(String[] words, int maxWidth) {
    this.n = words.length;
    List<String> result = new ArrayList();
    int left = 0, right = 0;
    while (left < n) {
      int[] range = findRangeOfCharsInOneLine(words, left, maxWidth);

      right = range[0];
      int width = range[1];
      int wordsNum = right - left;
      int places = wordsNum - 1;
      int spacesToDistribute = maxWidth - width;


      int eqDistr = places == 0 ? 0 : spacesToDistribute / places;
      int extraDistr = places == 0 ? 0 : spacesToDistribute % places;

      if (right == n) {
        eqDistr = 0;
        extraDistr = 0;
      }

      StringBuilder sb = new StringBuilder();
      while (left < right) {
        sb.append(words[left++]);
        if (left == right) break;
        sb.append(" ");
        for (int i = 0; i < eqDistr; i++) sb.append(" ");
        if (extraDistr-- > 0) sb.append(" ");
      }
      while (sb.length() < maxWidth) sb.append(" ");
      result.add(sb.toString());
      left = right;
    }

    return result;
  }

  // returns number of words, length of a string
  int[] findRangeOfCharsInOneLine(String[] word, int start, int maxWidth) {
    int count = word[start++].length();
    while (start < n && count + 1 + word[start].length() <= maxWidth) {
      count += word[start++].length() + 1;
    }
    return new int[]{start, count};
  }

  public static void main(String[] args) {
    TextJustification tj = new TextJustification();
    tj.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
  }
}
