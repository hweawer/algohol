package edu.agus.leetcode.easy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class TheKWeakestRowsInAMatrix {
  public static class PQE {
    int[] row;
    int index;

    public PQE(int[] row, int index) {
      this.row = row;
      this.index = index;
    }
  }

  public int[] kWeakestRows(int[][] mat, int k) {
    int[] result = new int[k];
    Queue<PQE> q = new PriorityQueue<>((x, y) -> {
      int s1 = IntStream.of(x.row).sum();
      int s2 = IntStream.of(y.row).sum();
      if (s1 != s2) return s1 - s2;
      return x.index - y.index;
    });
    for (int i = 0; i < mat.length; i++) {
      q.add(new PQE(mat[i], i));
    }
    int i = 0;
    while (k != 0) {
      result[i] = q.poll().index;
      i++;
      k--;
    }
    return result;
  }
}
