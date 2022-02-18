package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
  List<List<Integer>> res = new ArrayList<>();

  public void backtracking(int[] nums, int start, List<Integer> path) {
    if (start >= nums.length) res.add(new ArrayList<>(path));
    else {
      backtracking(nums, start + 1, new ArrayList<>(path));
      List<Integer> l = new ArrayList<>(path);
      l.add(nums[start]);
      backtracking(nums, start + 1, l);
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    backtracking(nums, 0, new ArrayList<>());
    return res;
  }
}
