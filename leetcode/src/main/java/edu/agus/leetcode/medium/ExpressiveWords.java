package edu.agus.leetcode.medium;

public class ExpressiveWords {
  public int expressiveWords(String s, String[] words) {
    int count = 0;
    for (String word: words) {
      if (isExtension(s, word)) {
        count++;
      }
    }
    return count;
  }

  boolean isExtension(String f, String s) {
    int first = 0;
    int second = 0;
    while(first < f.length() && second < s.length()) {
      if (f.charAt(first) != s.charAt(second)) return false;
      char c = f.charAt(first);
      int startF = first;
      while (first < f.length() && f.charAt(first) == c) {
        first++;
      }
      int groupF = first - startF;
      int startS = second;
      while (second < s.length() && s.charAt(second) == c) {
        second++;
      }
      int groupS = second - startS;
      if (groupF == groupS || ((groupF > groupS) && groupF > 2)) continue;
      return false;
    }

    return first == f.length() && second == s.length();
  }
}
