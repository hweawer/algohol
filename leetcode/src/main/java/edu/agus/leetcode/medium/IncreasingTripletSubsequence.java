package edu.agus.leetcode.medium;

public class IncreasingTripletSubsequence {
  public boolean increasingTriplet(int[] nums) {
    int first_min = Integer.MAX_VALUE;
    int second_min = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num > second_min) return true;
      else if (num > first_min) {
        second_min = Math.min(second_min, num);
      } else {
        first_min = Math.min(first_min, num);
      }
    }
    return false;
  }
}
