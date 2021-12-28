package edu.agus.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class MinimumSubsequenceInNonIncreasingOrder {
  public List<Integer> minSubsequence(int[] nums) {
    List<Integer> result = new ArrayList<>();
    Integer[] sorted = IntStream.of(nums).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);
    int sum = 0;
    for (Integer integer : sorted) {
      sum += integer;
    }
    int rollingSum = 0;
    int i = 0;
    while (rollingSum < sum) {
      result.add(sorted[i]);
      rollingSum += sorted[i];
      sum -= sorted[i];
      i++;
    }
    return result;
  }
}
