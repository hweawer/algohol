package edu.agus.leetcode.medium;

public class MaximumPointsYouCanObtainFromCards {
  public int maxScore(int[] cardPoints, int k) {
    int window = 0;
    for (int i = 0; i < k; i++) {
      window += cardPoints[i];
    }
    int res = window;
    for (int left = k - 2, right = cardPoints.length - 1; left >= -1; left--, right--) {
      window = window - cardPoints[left + 1] + cardPoints[right];
      res = Math.max(res, window);
    }
    return res;
  }
}
