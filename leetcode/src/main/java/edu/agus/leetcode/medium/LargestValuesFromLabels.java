package edu.agus.leetcode.medium;

import java.util.*;

public class LargestValuesFromLabels {
  class Pair {
    int first;
    int second;

    Pair(int f, int s) {
      this.first = f;
      this.second = s;
    }
  }

  public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
    List<Pair> pairs = new ArrayList();
    for (int i = 0; i < values.length; i++) {
      pairs.add(new Pair(labels[i], values[i]));
    }
    Collections.sort(pairs, (x, y) -> Integer.compare(y.second, x.second));
    Map<Integer, Integer> counter = new HashMap();
    int i = 0;
    int taken = 0;
    int result = 0;
    while (taken < numWanted && i < pairs.size()) {
      Pair pair = pairs.get(i);
      int freq = counter.getOrDefault(pair.first, 0);
      if (freq < useLimit) {
        result += pair.second;
        taken++;
        counter.put(pair.first, freq + 1);
      }
      i++;
    }
    return result;
  }
}
