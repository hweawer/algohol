package edu.agus.leetcode.medium;

public class TossStrangeCoins {
  public double probabilityOfHeads(double[] prob, int target) {
    int probLen = prob.length;
    double[][] dp = new double[probLen + 1][target + 1];
    dp[0][0] = 1;

    for (int i = 1; i <= probLen; ++i) {
      double headProb = prob[i - 1], tailProb = 1 - headProb;
      dp[i][0] = dp[i - 1][0] * tailProb;
      for (int j = 1; j <= target; j++) {
        dp[i][j] = dp[i - 1][j - 1] * headProb + dp[i - 1][j] * tailProb;
      }
    }
    return dp[probLen][target];
  }
}
