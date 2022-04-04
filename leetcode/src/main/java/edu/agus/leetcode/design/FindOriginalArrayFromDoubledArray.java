package edu.agus.leetcode.design;

import java.util.*;

public class FindOriginalArrayFromDoubledArray {
  public int[] findOriginalArray(int[] changed) {
    if (changed.length % 2 != 0) return new int[]{};
    Arrays.sort(changed);
    List<Integer> res = new ArrayList();
    Map<Integer, Integer> dict = new HashMap();
    for (int c : changed) {
      if (c % 2 == 0 && dict.containsKey(c / 2) && dict.get(c / 2) > 0) {
        int p = dict.get(c / 2) - 1;
        dict.put(c / 2, p);
        res.add(c / 2);
      } else {
        int p = dict.getOrDefault(c, 0) + 1;
        dict.put(c, p);
      }
    }
    if (res.size() != changed.length / 2) return new int[]{};

    int[] ans = new int[res.size()];
    for (int i = 0; i < res.size(); i++) {
      ans[i] = res.get(i);
    }

    return ans;
  }
}
