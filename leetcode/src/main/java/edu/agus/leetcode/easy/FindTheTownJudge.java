package edu.agus.leetcode.easy;

public class FindTheTownJudge {
  public int findJudge(int n, int[][] trust) {
    int[] counter = new int[n + 1];

    for (int[] person : trust) {
      counter[person[0]]--;
      counter[person[1]]++;
    }

    for (int i = 1; i <= n; i++) {
      if (counter[i] == n - 1) return i;
    }
    return -1;
  }
}
