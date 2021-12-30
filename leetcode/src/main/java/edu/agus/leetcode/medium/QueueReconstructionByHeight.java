package edu.agus.leetcode.medium;

import java.util.Arrays;

public class QueueReconstructionByHeight {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (x, y) -> {
      if (x[0] == y[0]) {
        return y[1] - x[1];
      }
      return x[0] - y[0];
    });

    for (int i = people.length - 2; i >= 0; i--) {
      int[] iter = people[i];
      int k = iter[1];
      for (int j = i; j < i + k; j++) {
        people[j] = people[j + 1];
      }
      people[i + k] = iter;
    }
    return people;
  }
}
