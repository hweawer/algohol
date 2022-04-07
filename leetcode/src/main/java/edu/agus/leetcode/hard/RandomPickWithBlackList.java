package edu.agus.leetcode.hard;

import java.util.*;

public class RandomPickWithBlackList {
  Map<Integer, Integer> m;
  Random r;
  int wlen;

  public RandomPickWithBlackList(int n, int[] b) {
    m = new HashMap<>();
    r = new Random();
    wlen = n - b.length;
    Set<Integer> w = new HashSet<>();
    for (int i = wlen; i < n; i++) w.add(i);
    for (int x : b) w.remove(x);
    Iterator<Integer> wi = w.iterator();
    for (int x : b)
      if (x < wlen)
        m.put(x, wi.next());
  }

  public int pick() {
    int k = r.nextInt(wlen);
    return m.getOrDefault(k, k);
  }
}
