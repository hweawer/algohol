package edu.agus.leetcode.medium;

// 1, 0, 0, 1
// 1, 0, 1
// 1, 0, 0
// 0, 0, 1


public class MaximizeDistanceToClosestPerson {
  public int maxDistToClosest(int[] seats) {
    int n = seats.length;
    int prev = -1;
    int res = 0;

    for (int i = 0; i < n; i++) {
      if (seats[i] == 1) {
        res = Math.max(res, distance(prev, i, n));
        prev = i;
      }
    }
    return Math.max(res, distance(prev, n, n));
  }

  int distance(int prev, int i, int n) {
    if (prev == -1) {
      return i;
    } else if (i == n) {
      return n - 1 - prev;
    } else {
      return (i - prev) / 2;
    }
  }
}
