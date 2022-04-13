package edu.agus.leetcode.medium;

import java.util.Iterator;
import java.util.TreeSet;

public class ExamRoom {
  TreeSet<Integer> set = new TreeSet();
  int n;

  public ExamRoom(int n) {
    this.n = n;
  }

  public int seat() {
    int res = 0;
    if (set.size() == 0) {
      set.add(0);
    } else if (set.size() == 1) {
      int first = set.first();
      if (first < n / 2) {
        set.add(n - 1);
        res = n - 1;
      } else {
        set.add(0);
      }
    } else {
      int dist = -1;
      int pos = -1;
      Iterator<Integer> it = set.iterator();
      int prev = it.next();
      if (prev > 0) {
        pos = 0;
        dist = prev;
      }
      while (it.hasNext()) {
        int cur = it.next();
        if ((cur - prev) / 2 > dist) {
          dist = (cur - prev) / 2;
          pos = prev + dist;
        }
        prev = cur;
      }
      if ((n - 1) - prev > dist) {
        pos = n - 1;
      }
      set.add(pos);
      res = pos;
    }
    return res;
  }

  public void leave(int p) {
    set.remove(p);
  }
}
