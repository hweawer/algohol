package edu.agus.leetcode.easy;

import java.util.Arrays;

public class MaximumUnitsOnTruck {
  public int maximumUnits(int[][] boxTypes, int truckSize) {
    Arrays.sort(boxTypes, (x, y) -> y[1] - x[1]);
    int res = 0;
    int i = 0;
    while (truckSize != 0 && i < boxTypes.length) {
      if (boxTypes[i][0] <= truckSize) {
        res += boxTypes[i][0] * boxTypes[i][1];
        truckSize -= boxTypes[i][0];
      } else {
        res += truckSize * boxTypes[i][1];
        truckSize = 0;
      }
      i++;
    }
    return res;
  }
}
