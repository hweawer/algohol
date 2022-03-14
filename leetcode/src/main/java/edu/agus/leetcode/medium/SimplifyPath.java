package edu.agus.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {
  public String simplifyPath(String path) {
    Deque<String> queue = new LinkedList<>();
    String[] split = path.split("/");
    for (String s : split) {
      if (s.equals("..")) {
        if (queue.size() > 1) queue.pop();
      } else if (s.length() > 0 && !s.equals(".")) queue.push(s);
    }
    StringBuilder sb = new StringBuilder();
    sb.append("/");
    while (!queue.isEmpty()) {
      sb.append(queue.pollLast());
      sb.append("/");
    }
    if (sb.length() > 1) sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }
}
