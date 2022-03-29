package edu.agus.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
  public char add(char x, boolean plus) {
    if (x == '0' && plus) return '1';
    else if (x == '0' && !plus) return '9';
    else if (x == '1' && plus) return '2';
    else if (x == '1' && !plus) return '0';
    else if (x == '2' && plus) return '3';
    else if (x == '2' && !plus) return '1';
    else if (x == '3' && plus) return '4';
    else if (x == '3' && !plus) return '2';
    else if (x == '4' && plus) return '5';
    else if (x == '4' && !plus) return '3';
    else if (x == '5' && plus) return '6';
    else if (x == '5' && !plus) return '4';
    else if (x == '6' && plus) return '7';
    else if (x == '6' && !plus) return '5';
    else if (x == '7' && plus) return '8';
    else if (x == '7' && !plus) return '6';
    else if (x == '8' && plus) return '9';
    else if (x == '8' && !plus) return '7';
    else if (x == '9' && plus) return '0';
    else return '8';
  }


  public int openLock(String[] deadends, String target) {
    Set<String> visited = new HashSet();
    for(String end: deadends) visited.add(end);
    String start = "0000";
    Queue<String> q = new LinkedList();
    q.add(start);
    int level = -1;
    while(!q.isEmpty()) {
      int size = q.size();
      level++;
      for(int i = 0; i < size; i++) {
        String combination = q.poll();
        if (combination.equals(target)) return level;
        if (!visited.contains(combination)) {
          for(int j = 0; j < 4; j++) {
            char c = combination.charAt(j);
            char pos = add(c, true);
            char neg = add(c, false);
            StringBuilder sb1 = new StringBuilder(combination);
            StringBuilder sb2 = new StringBuilder(combination);
            sb1.setCharAt(j, pos);
            sb2.setCharAt(j, neg);
            String s1 = sb1.toString();
            String s2 = sb2.toString();
            q.add(s1);
            q.add(s2);
          }
          visited.add(combination);
        }
      }
    }
    return -1;
  }
}
