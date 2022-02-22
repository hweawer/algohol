package edu.agus.leetcode.medium;

public class JumpGame2 {
  public int jump(int[] nums) {
    int n = nums.length;
    int[] mem = new int[n];
    mem[n - 1] = 0;
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i] == 0) {
        mem[i] = Integer.MAX_VALUE;
      } else {
        int bound = Math.min(i + nums[i] + 1, n);
        int min = Integer.MAX_VALUE;
        for (int j = i + 1; j < bound; j++) {
          min = Math.min(mem[j], min);
        }
        mem[i] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
      }
    }
    return mem[0];
  }
}
