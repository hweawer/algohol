package edu.agus.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class ScoreOfParentheses {

  public int scoreOfParentheses(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    int score = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(score);
        score = 0;
      } else score = stack.pop() + Math.max(2 * score, 1);
    }
    return score;
  }
}
