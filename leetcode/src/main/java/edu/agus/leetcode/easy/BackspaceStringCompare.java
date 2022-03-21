package edu.agus.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackspaceStringCompare {
  public String make(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '#') {
        if (!stack.isEmpty()) stack.pop();
      } else stack.push(s.charAt(i));
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.toString();
  }

  public boolean backspaceCompare(String s, String t) {
    String s1 = make(s);
    String s2 = make(t);
    return s1.equals(s2);
  }
}
