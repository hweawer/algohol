package edu.agus.leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;

public class ConfusingNumber2 {
  public int confusingNumberII(int n) {
    int[] numbers = new int[]{0, 1, 6, 8, 9};
    Queue<Integer> q = new LinkedList();
    q.add(1);
    q.add(6);
    q.add(8);
    q.add(9);

    int count = 0;
    while (!q.isEmpty()) {
      int x = q.poll();
      if (isConfusing(x)) count++;

      for (int num : numbers) {
        if (((n - num) / 10) < x) break;
        q.add(x * 10 + num);
      }
    }
    return count;
  }

  boolean isConfusing(int n) {
    int from = n;
    int to = 0;
    while (n > 0) {
      int num = n % 10;
      if (num == 6) num = 9;
      else if (num == 9) num = 6;
      to = to * 10 + num;
      n /= 10;
    }

    return from != to;
  }
}
