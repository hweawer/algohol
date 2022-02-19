package edu.agus.leetcode.medium;

public class SortColors {
  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public void sortColors(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        int j = i;
        while (j >= 1 && nums[j] < nums[j - 1]) {
          swap(nums, j, j - 1);
          j--;
        }
      }
    }
  }
}
