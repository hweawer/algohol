package edu.agus.leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindRelativeRanks {
  public static class PQE {
    public int score;
    public int index;

    public PQE(int score, int index) {
      this.score = score;
      this.index = index;
    }
  }

  public Comparator<PQE> cmp = (x, y) -> y.score - x.score;

  public String[] findRelativeRanks(int[] score) {
    Queue<PQE> pq = new PriorityQueue<>(cmp);
    String[] result = new String[score.length];

    for (int i = 0; i < score.length; i++) {
      pq.add(new PQE(score[i], i));
    }

    int place = 1;
    while (!pq.isEmpty()) {
      PQE top = pq.poll();
      if (place == 1) {
        result[top.index] = "Gold Medal";
      } else if (place == 2) {
        result[top.index] = "Silver Medal";
      } else if (place == 3) {
        result[top.index] = "Bronze Medal";
      } else {
        result[top.index] = Integer.valueOf(place).toString();
      }
      place++;
    }
    return result;
  }
}
