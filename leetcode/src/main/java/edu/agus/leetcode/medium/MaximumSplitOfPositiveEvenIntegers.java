package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class MaximumSplitOfPositiveEvenIntegers {
  public List<Long> maximumEvenSplit(long finalSum) {
    List<Long> result = new ArrayList();
    if (finalSum % 2 != 0) return result;
    long it = 2;
    while (finalSum >= it) {
      finalSum -= it;
      result.add(it);
      it += 2;
    }

    if (finalSum != 0) {
      result.set(result.size() - 1, finalSum + it - 2);
    }
    return result;
  }
}
