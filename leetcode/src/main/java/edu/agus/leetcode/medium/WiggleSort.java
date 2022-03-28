package edu.agus.leetcode.medium;

public class WiggleSort {
  int index = 10000;
  int[] count = new int[index + 1];

  public void wiggleSort(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      count[nums[i]]++;
    }

    for (int i = 1; i < nums.length; i += 2) {
      nums[i] = nextVal();
    }

    for (int i = 0; i < nums.length; i += 2) {
      nums[i] = nextVal();
    }
  }

  private int nextVal() {
    while (count[index] == 0) {
      index--;
    }
    count[index]--;
    return index;
  }
}
