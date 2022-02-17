package edu.agus.leetcode.medium;

import java.util.*;

public class CombinationSum2 {
  List<List<Integer>> res = new ArrayList<>();
  List<Integer> perm = new ArrayList<>();

  public void dfs(int[] candidates, int s, int start) {
    if (s < 0) return;
    else if (s == 0) {
      res.add(new ArrayList<>(perm));
    } else {
      int prev = -1;
      for (int i = start; i < candidates.length; i++) {
        if (candidates[i] == prev)
          continue;
        perm.add(candidates[i]);
        dfs(candidates, s - candidates[i], i + 1);
        perm.remove(perm.size() - 1);
        prev = candidates[i];
      }
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    dfs(candidates, target, 0);
    return res;
  }
}
