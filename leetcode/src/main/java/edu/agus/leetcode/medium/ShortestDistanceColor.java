package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestDistanceColor {
  public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
    Map<Integer, List<Integer>> colorsIdx = new HashMap();
    int n = colors.length;
    List<Integer> res = new ArrayList();
    for (int i = 0; i < n; i++) {
      List<Integer> indexes = colorsIdx.getOrDefault(colors[i], new ArrayList());
      indexes.add(i);
      colorsIdx.put(colors[i], indexes);
    }
    for (int[] q : queries) {
      if (!colorsIdx.containsKey(q[1])) res.add(-1);
      else if (colors[q[0]] == q[1]) res.add(0);
      else {
        List<Integer> searchList = colorsIdx.get(q[1]);
        int left = 0;
        int right = searchList.size() - 1;
        while (left <= right) {
          int mid = left + (right - left) / 2;
          if (searchList.get(mid) < q[0]) {
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        }
        int found;
        if (right < 0) {
          found = searchList.get(left);
        } else if (left >= searchList.size()) {
          found = searchList.get(right);
        } else {
          found = (searchList.get(left) - q[0]) < (q[0] - searchList.get(right)) ? searchList.get(left) : searchList.get(right);
        }
        res.add(Math.abs(q[0] - found));
      }
    }
    return res;
  }
}
