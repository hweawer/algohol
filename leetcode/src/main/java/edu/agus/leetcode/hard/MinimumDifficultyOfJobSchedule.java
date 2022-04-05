package edu.agus.leetcode.hard;

public class MinimumDifficultyOfJobSchedule {
  public int minDifficulty(int[] jobDifficulty, int d) {
    int n = jobDifficulty.length;
    if (d > n) return -1;

    int[][] dp = new int[n][d + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < d + 1; j++) {
        dp[i][j] = Integer.MAX_VALUE;
      }
    }

    dp[n - 1][d] = jobDifficulty[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      dp[i][d] = Math.max(dp[i + 1][d], jobDifficulty[i]);
    }

    for (int day = d - 1; day > 0; day--) {
      for (int i = day - 1; i < n - (d - day); i++) {
        int largest = 0;
        for (int j = i; j < n - (d - day); j++) {
          largest = Math.max(largest, jobDifficulty[j]);
          dp[i][day] = Math.min(dp[i][day], largest + dp[j + 1][day + 1]);
        }
      }
    }
    return dp[0][1];
  }
}
