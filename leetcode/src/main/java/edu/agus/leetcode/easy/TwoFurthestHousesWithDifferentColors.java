package edu.agus.leetcode.easy;

public class TwoFurthestHousesWithDifferentColors {
  public int maxDistance(int[] colors) {
    for (int i = 0; i < colors.length; i++) {
      if (colors[0] != colors[colors.length - 1 - i] || colors[colors.length - 1] != colors[i]) {
        return colors.length - 1 - i;
      }
    }
    return 0;
  }
}
