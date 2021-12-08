package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum {
  //todo: it passes from the first time BUT THIS IS VERY BAD SOLUTION
  //Analyze possibilities of iterative backtracking
  List<List<Integer>> result = new ArrayList<>();

  public void rec(List<Integer> candidates, int target, List<Integer> path) {
    if (target < 0) return;
    else if (target == 0) {
      result.add(path);
    } else if (candidates.size() == 0) return;
    else {
      List<Integer> withElemPath = new ArrayList<>(path);
      withElemPath.add(candidates.get(0));
      rec(candidates, target - candidates.get(0), withElemPath);
      rec(candidates.subList(1, candidates.size()), target, path);
    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    rec(Arrays.stream(candidates)
        .boxed()
        .collect(Collectors.toList()), target, new ArrayList<>());
    return result;
  }

  public static void main(String[] args) {
    CombinationSum cs = new CombinationSum();
    System.out.println(cs.combinationSum(new int[]{2, 3, 6, 7}, 7));
  }
}
