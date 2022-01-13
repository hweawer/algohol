package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
  static List<List<Integer>> combinations = new ArrayList<>();

  public void backtracking(int[] arr, List<Integer> acc, int k, int start) {
    if (k == 0) combinations.add(acc);
    else {
      if (start < arr.length) {
        List<Integer> copy = new ArrayList<>(acc);
        copy.add(arr[start]);
        backtracking(arr, copy, k - 1, start + 1);
        backtracking(arr, acc, k, start + 1);
      }
    }
  }

  public List<List<Integer>> combine(int n, int k) {
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = i + 1;
    }
    backtracking(arr, new ArrayList<>(), k, 0);
    return combinations;
  }
}
