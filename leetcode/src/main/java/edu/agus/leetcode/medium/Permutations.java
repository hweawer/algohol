package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

  public List<List<Integer>> rec(Integer[] current, int l, int r) {
    List<List<Integer>> al = new ArrayList<>();
    if (l == r) {
      al.add(Arrays.asList(current));
    } else {
      for (int i = l; i < r; i++) {
        Integer[] arr = swap(current, l, i);
        List<List<Integer>> perm = rec(arr, l + 1, r);
        al.addAll(perm);
      }
    }
    return al;
  }

  public Integer[] swap(Integer[] x, int i, int j) {
    Integer[] res = Arrays.copyOf(x, x.length);
    int temp = res[i];
    res[i] = res[j];
    res[j] = temp;
    return res;
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>();
    if (nums.length == 0) return permutations;
    else {
      return rec(Arrays.stream(nums)
          .boxed()
          .toArray(Integer[]::new), 0, nums.length);
    }
  }
}
