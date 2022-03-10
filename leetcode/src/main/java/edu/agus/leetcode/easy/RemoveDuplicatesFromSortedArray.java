package edu.agus.leetcode.easy;

public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 1) return 1;
    int prev = nums[0];
    int ilast = 1;
    for (int i = 1; i < nums.length;) {
      if (nums[i] != prev) {
        prev = nums[i];
        ilast++;
        i++;
      } else {
        while (i < nums.length && nums[i] == prev) i++;
        if (i < nums.length) {
          nums[ilast] = nums[i];
          prev = nums[ilast];
          ilast++;
        }
      }
    }
    return ilast;
  }
}
