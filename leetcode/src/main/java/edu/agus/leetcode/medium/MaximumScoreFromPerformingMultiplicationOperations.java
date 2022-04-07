package edu.agus.leetcode.medium;

public class MaximumScoreFromPerformingMultiplicationOperations {
  int dfs(int i, int left, int m, int n, int[][] dp, int[] multipliers, int[] nums) {
    if (i == m) return 0;

    int mult = multipliers[i];
    int right = n - 1 - (i - left);
    if (dp[i][left] == 0) {
      dp[i][left] = Math.max(mult * nums[left] + dfs(i + 1, left + 1, m, n, dp, multipliers, nums), mult * nums[right] + dfs(i + 1, left, m, n, dp, multipliers, nums));
    }

    return dp[i][left];
  }

  public int maximumScore(int[] nums, int[] multipliers) {
    int n = nums.length;
    int m = multipliers.length;
    int[][] dp = new int[m][m];
    return dfs(0, 0, m, n, dp, multipliers, nums);
  }
}
