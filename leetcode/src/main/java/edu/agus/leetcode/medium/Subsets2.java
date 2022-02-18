package edu.agus.leetcode.medium;

import java.util.*;

public class Subsets2 {
  List<List<Integer>> res = new ArrayList<>();

  public void backtracking(int[] nums, int start, List<Integer> list) {
    if (start >= nums.length) res.add(new ArrayList<>(list));
    else {
      list.add(nums[start]);
      backtracking(nums, start + 1, list);
      list.remove(list.size() - 1);

      while (start < nums.length - 1 && nums[start] == nums[start + 1]) start++;
      backtracking(nums, start + 1, list);
    }
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    backtracking(nums, 0, new ArrayList<>());
    return res;
  }
}
