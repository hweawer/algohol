package edu.agus.leetcode.easy;

public class SquaresOfASortedArray {
  public int[] sortedSquares(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    int[] res = new int[nums.length];
    int pos = nums.length - 1;
    while (l <= r) {
      int lr = nums[l] * nums[l];
      int rr = nums[r] * nums[r];
      if (rr >= lr) {
        res[pos] = rr;
        r--;
      } else {
        res[pos] = lr;
        l++;
      }
      pos--;
    }
    return res;
  }
}
