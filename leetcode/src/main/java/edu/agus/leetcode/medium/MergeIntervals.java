package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    List<List<Integer>> matrix = new ArrayList<>();
    Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
    matrix.add(Arrays.stream(intervals[0]).boxed().collect(Collectors.toList()));
    for (int i = 1; i < intervals.length; i++) {
      int[] cur = intervals[i];
      List<Integer> last = matrix.get(matrix.size() - 1);
      if (cur[0] <= last.get(1)) last.set(1, Math.max(last.get(1), cur[1]));
      else matrix.add(Arrays.stream(cur).boxed().collect(Collectors.toList()));
    }
    int[][] result = new int[matrix.size()][2];
    for (int i = 0; i < matrix.size(); i++) {
      int[] pair = new int[2];
      pair[0] = matrix.get(i).get(0);
      pair[1] = matrix.get(i).get(1);
      result[i] = pair;
    }
    return result;
  }

  public static void main(String[] args) {
    merge(new int[][] {
        {1, 3},
        {2, 6},
        {8, 10},
        {15, 18}
    });
  }
}
