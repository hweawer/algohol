package edu.agus.leetcode.medium;

import java.util.List;

public class LeftmostColumnWithAtLeastOne {
  interface BinaryMatrix {
    int get(int row, int col);

    List<Integer> dimensions();
  }

  public int find(BinaryMatrix binaryMatrix, int row, int cols, int target) {
    int l = 0;
    int r = cols - 1;
    boolean contains = false;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      int middleElem = binaryMatrix.get(row, mid);
      if (middleElem < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
        if (middleElem == target) {
          contains = true;
        }
      }
    }
    return contains ? l : Integer.MAX_VALUE;
  }

  public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    int rows = binaryMatrix.dimensions().get(0);
    int cols = binaryMatrix.dimensions().get(1);

    int total = Integer.MAX_VALUE;
    for (int i = 0; i < rows; i++) {
      total = Math.min(total, find(binaryMatrix, i, cols, 1));
    }
    return total == Integer.MAX_VALUE ? -1 : total;
  }
}
