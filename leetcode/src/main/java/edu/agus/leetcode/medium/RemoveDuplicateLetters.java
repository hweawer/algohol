package edu.agus.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters {
  public String removeDuplicateLetters(String s) {
    int[] lastIndexOf = new int[26];
    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i) - 'a';
      lastIndexOf[c] = i;
    }
    boolean[] visited = new boolean[26];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i) - 'a';
      if (visited[c]) continue;
      while (!stack.isEmpty() && stack.peek() > c && i < lastIndexOf[stack.peek()]) {
        visited[stack.pop()] = false;
      }
      stack.push(c);
      visited[s.charAt(i) - 'a'] = true;
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      char c = (char) (stack.pop() + 'a');
      sb.append(c);
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    String in = "bcabc";
    RemoveDuplicateLetters r = new RemoveDuplicateLetters();
    r.removeDuplicateLetters(in);
  }
}
