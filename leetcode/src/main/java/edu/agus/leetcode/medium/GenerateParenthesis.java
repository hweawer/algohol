package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
  List<String> result = new ArrayList<>();

  void dfs(int open, int closed, int n, StringBuilder cur) {
    if (open == n && closed == n) {
      result.add(cur.toString());
    } else {
      StringBuilder copy = new StringBuilder(cur);
      if (open < n) {
        dfs(open + 1, closed, n, cur.append("("));
      }
      if (closed < n && closed < open) {
        dfs(open, closed + 1, n, copy.append(")"));
      }
    }
  }

  public List<String> generateParenthesis(int n) {
    dfs(0, 0, n, new StringBuilder());
    return result;
  }
}
