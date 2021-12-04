package edu.agus.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {
  public boolean isValid(String s) {
    Deque<Character> st = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char x = s.charAt(i);
      switch (x) {
        case '(':
        case '[':
        case '{':
          st.push(x);
          break;
        case ')':
          if (st.isEmpty() || st.peek() != '(') return false;
          else st.pop();
          break;
        case ']':
          if (st.isEmpty() || st.peek() != '[') return false;
          else st.pop();
          break;
        case '}':
          if (st.isEmpty() || st.peek() != '{') return false;
          else st.pop();
          break;
      }
    }
    return st.isEmpty();
  }
}
