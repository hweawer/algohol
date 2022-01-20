package edu.agus.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      triangle.add(new ArrayList<>());
    }
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          triangle.get(i).add(1);
        } else {
          int res = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
          triangle.get(i).add(res);
        }
      }
    }
    return triangle;
  }
}
