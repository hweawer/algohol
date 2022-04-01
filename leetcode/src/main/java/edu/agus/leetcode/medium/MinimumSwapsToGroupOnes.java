package edu.agus.leetcode.medium;

public class MinimumSwapsToGroupOnes {
  public int minSwaps(int[] data) {
    int ones = 0;
    for(int i: data) {
      if (i == 1) ones++;
    }
    int swaps = 0;
    for(int i = 0; i < ones; i++) {
      if (data[i] == 0) swaps++;
    }
    int cur = swaps;
    for(int l = 1, r = ones; r < data.length; l++, r++) {
      if (data[l-1] == 0) cur--;
      if (data[r] == 0) cur++;
      swaps = Math.min(swaps, cur);
    }
    return swaps;
  }
}
