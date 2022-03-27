package edu.agus.leetcode.medium;

public class MinDominoRotations {
  public int minDominoRotations(int[] tops, int[] bottoms) {
    int[] top = new int[6];
    int[] bot = new int[6];
    int[] len = new int[6];
    int n = tops.length;
    for (int i = 0; i < 6; i++) {
      len[i] = n;
    }
    for(int i = 0; i < n; i++) {
      if (tops[i] != bottoms[i]) {
        bot[bottoms[i] - 1]++;
        top[tops[i] - 1]++;
      }
      else {
        len[tops[i] - 1]--;
      }
    }
    int res = Integer.MAX_VALUE;
    for(int i = 0; i < 6; i++) {
      if (top[i] + bot[i] == len[i]) {
        res = Math.min(res, Math.min(top[i], bot[i]));
      }
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }
}
