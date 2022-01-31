package edu.agus.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
  public List<Integer> getRow(int rowIndex) {
    List<List<Integer>> triangle = new ArrayList<>(rowIndex + 1);
    for (int i = 0; i <= rowIndex; i++) {
      triangle.add(new ArrayList<>());
    }
    for (int i = 0; i <= rowIndex; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) triangle.get(i).add(1);
        else {
          int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
          triangle.get(i).add(val);
        }
      }
    }
    return triangle.get(rowIndex);
  }
}
