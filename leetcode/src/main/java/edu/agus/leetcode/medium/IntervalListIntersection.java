package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    int f = 0;
    int s = 0;
    List<List<Integer>> res = new ArrayList<>();
    while (f < firstList.length && s < secondList.length) {
      if (intersect(firstList[f], secondList[s])) {
        int left = Math.max(firstList[f][0], secondList[s][0]);
        int right = Math.min(firstList[f][1], secondList[s][1]);
        List<Integer> it = new ArrayList<>();
        it.add(left);
        it.add(right);
        res.add(it);
      }
      if (firstList[f][1] >= secondList[s][1]) s++;
      else f++;
    }
    int[][] ans = new int[res.size()][];
    for (int i = 0; i < ans.length; i++) {
      ans[i] = new int[]{res.get(i).get(0), res.get(i).get(1)};
    }
    return ans;
  }

  boolean intersect(int[] f1, int[] f2) {
    if (f1[1] < f2[0]) return false;
    else return f1[0] <= f2[1];
  }
}
