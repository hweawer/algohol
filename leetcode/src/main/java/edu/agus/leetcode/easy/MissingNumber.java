package edu.agus.leetcode.easy;

public class MissingNumber {
  public int missingNumber(int[] nums) {
    int n = nums.length;
    int[] map = new int[n + 1];
    for (int num : nums) {
      map[num] = 1;
    }
    for (int i = 0; i < map.length; i++) {
      if (map[i] != 1) return i;
    }
    return -1;
  }
}
