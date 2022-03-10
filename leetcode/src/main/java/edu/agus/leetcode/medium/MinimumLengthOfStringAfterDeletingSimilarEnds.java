package edu.agus.leetcode.medium;

import java.util.LinkedList;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {
  public int minimumLength(String s) {
    LinkedList<Character> list = new LinkedList<>();
    char[] chars = s.toCharArray();
    for (char c : chars) {
      list.addLast(c);
    }
    while (list.size() > 1 && list.getFirst().equals(list.getLast())) {
      char c = list.getFirst();
      while (list.size() > 0 && list.getFirst().equals(c)) list.removeFirst();
      while (list.size() > 0 && list.getLast().equals(c)) list.removeLast();
    }
    return list.size();
  }
}
