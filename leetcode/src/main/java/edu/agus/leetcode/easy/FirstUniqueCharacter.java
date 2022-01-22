package edu.agus.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueCharacter {
  public int firstUniqChar(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    Queue<Character> q = new LinkedList<>();

    char[] chars = s.toCharArray();
    for (char c : chars) {
      q.add(c);
      int v = map.getOrDefault(c, 0) + 1;
      map.put(c, v);
    }
    int ind = 0;
    while (!q.isEmpty() && map.get(q.peek()) != 1) {
      q.poll();
      ind++;
    }
    if (q.isEmpty()) return -1;
    return ind;
  }
}
