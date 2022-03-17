package edu.agus.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator2 {
  public int calculate(String s) {
    if (s == null || s.isEmpty()) return 0;
    Deque<Integer> stack = new ArrayDeque<>();
    int number = 0;
    char operation = '+';
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) number = number * 10 + s.charAt(i) - '0';
      if ((!Character.isDigit(c) && !Character.isWhitespace(c)) || i == s.length() - 1) {
        if (operation == '+') stack.push(number);
        else if (operation == '-') stack.push(-number);
        else if (operation == '*') stack.push(stack.pop() * number);
        else if (operation == '/') stack.push(stack.pop() / number);
        operation = c;
        number = 0;
      }
    }
    int res = 0;
    while (!stack.isEmpty()) res += stack.pop();
    return res;
  }
}
