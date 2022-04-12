package edu.agus.leetcode.hard;

import java.util.*;

public class WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet(wordList);
    if (!set.contains(endWord)) return 0;
    Queue<String> q = new LinkedList();

    q.add(beginWord);
    int level = 1;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        String word = q.poll();
        char[] chars = word.toCharArray();
        for (int j = 0; j < word.length(); j++) {
          char temp = chars[j];
          for (char c = 'a'; c <= 'z'; c++) {
            chars[j] = c;
            String next = new String(chars);
            if (set.contains(next)) {
              if (next.equals(endWord)) return level + 1;
              q.add(next);
              set.remove(next);
            }
          }
          chars[j] = temp;
        }
      }
      level++;
    }
    return 0;
  }
}
