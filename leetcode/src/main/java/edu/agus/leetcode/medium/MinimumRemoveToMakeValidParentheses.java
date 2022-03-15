package edu.agus.leetcode.medium;

import java.util.*;

public class MinimumRemoveToMakeValidParentheses {
  public String minRemoveToMakeValid(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    Set<Integer> indexesToDelete = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i);
      if (c == ')' && stack.isEmpty()) indexesToDelete.add(i);
      else if (c == '(') stack.add(i);
      else if (c == ')') stack.pop();
    }
    while (!stack.isEmpty()) indexesToDelete.add(stack.pop());
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (!indexesToDelete.contains(i)) res.append(s.charAt(i));
    }
    return res.toString();
  }
}
