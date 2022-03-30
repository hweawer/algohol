package edu.agus.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGenericMutation {
  String[] replace(int i, String s) {
    StringBuilder str = new StringBuilder(s);
    if (str.charAt(i) == 'A') {
      str.setCharAt(i, 'C');
      String s1 = str.toString();
      str.setCharAt(i, 'G');
      String s2 = str.toString();
      str.setCharAt(i, 'T');
      String s3 = str.toString();
      return new String[]{s1, s2, s3};
    } else if (str.charAt(i) == 'C') {
      str.setCharAt(i, 'A');
      String s1 = str.toString();
      str.setCharAt(i, 'G');
      String s2 = str.toString();
      str.setCharAt(i, 'T');
      String s3 = str.toString();
      return new String[]{s1, s2, s3};
    } else if (str.charAt(i) == 'G') {
      str.setCharAt(i, 'A');
      String s1 = str.toString();
      str.setCharAt(i, 'C');
      String s2 = str.toString();
      str.setCharAt(i, 'T');
      String s3 = str.toString();
      return new String[]{s1, s2, s3};
    } else {
      str.setCharAt(i, 'A');
      String s1 = str.toString();
      str.setCharAt(i, 'C');
      String s2 = str.toString();
      str.setCharAt(i, 'G');
      String s3 = str.toString();
      return new String[]{s1, s2, s3};
    }
  }

  public int minMutation(String start, String end, String[] bank) {
    Set<String> set = new HashSet();
    for (String b : bank) set.add(b);
    if (!set.contains(end)) return -1;
    Queue<String> q = new LinkedList();
    q.add(start);
    int level = -1;
    while (!q.isEmpty()) {
      int size = q.size();
      level++;
      for (int i = 0; i < size; i++) {
        String s = q.poll();
        if (s.equals(end)) return level;
        for (int j = 0; j < 8; j++) {
          String[] comb = replace(j, s);
          for (String c : comb) {
            if (set.contains(c)) {
              q.add(c);
            }
          }
        }
      }
    }
    return -1;
  }
}
