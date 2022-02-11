package edu.agus.leetcode.medium;

import java.util.Arrays;

public class WiggleSubsequence {
  public int wiggleMaxLength(int[] nums) {
    int n = nums.length;
    int[] pos = new int[n];
    int[] neg = new int[n];
    Arrays.fill(pos, 1);
    Arrays.fill(neg, 1);
    int pos_max = pos[0];
    int neg_max = neg[0];
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          pos[i] = Math.max(pos[i], neg[i] + 1);
          pos_max = Math.max(pos_max, pos[i]);
        }
        if (nums[i] < nums[j]) {
          neg[i] = Math.max(neg[i], pos[i] + 1);
          neg_max = Math.max(neg_max, neg[i]);
        }
      }
    }
    return Math.max(pos_max, neg_max);
  }

}
