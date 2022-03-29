package edu.agus.leetcode.medium;

public class JumpSearch3 {
  boolean dfs(int[] arr, int cur, boolean[] visited) {
    if (arr[cur] == 0) return true;
    if (visited[cur]) return false;
    visited[cur] = true;
    if (cur - arr[cur] >= 0) {
      if (dfs(arr, cur - arr[cur], visited)) return true;
    }
    if (cur + arr[cur] < arr.length) {
      if (dfs(arr, cur + arr[cur], visited)) return true;
    }
    return false;
  }

  public boolean canReach(int[] arr, int start) {
    return dfs(arr, start, new boolean[arr.length]);
  }
}
