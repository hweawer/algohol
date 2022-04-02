package edu.agus.leetcode.contest.code_jam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ChainReactions {

  public static class Solution {
    static void dfs(HashSet<Integer>[] adj, int[] funFactors, int i, int[] res) {
      if (adj[i].isEmpty()) res[i] = funFactors[i];
      else {
        int min = Integer.MAX_VALUE;
        for (int child : adj[i]) {
          dfs(adj, funFactors, child, res);
          min = Math.min(min, res[child]);
        }
        res[i] = Math.max(funFactors[i], min);
      }
    }

    static void dfs2(HashSet<Integer>[] adj, int i, int[] marked, Set<Integer> visited) {
      if (visited.contains(i)) return;
      visited.add(i);
      if (!adj[i].isEmpty()) {
        int min = adj[i].iterator().next();
        for (int child : adj[i]) {
          if (marked[child] < marked[min]) min = child;
        }
        marked[min] = Math.max(marked[min], marked[i]);
        dfs2(adj, min, marked, visited);
        for (int child : adj[i]) {
          if (child != min) dfs2(adj, child, marked, visited);
        }
      }
    }

    static int[] parseArray(BufferedReader in, int n, int shift) throws IOException {
      String[] line = in.readLine().split(" ");
      int[] arr = new int[n];
      for (int j = shift; j < n; j++) arr[j] = Integer.parseInt(line[j - shift]);
      return arr;
    }

    public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(in.readLine());
      for (int i = 0; i < t; i++) {
        int n = Integer.parseInt(in.readLine());
        HashSet<Integer>[] income = new HashSet[n + 1];
        for (int j = 0; j < n + 1; j++) income[j] = new HashSet<>();
        int[] funFactors = parseArray(in, n + 1, 1);
        int[] connections = parseArray(in, n, 0);
        for (int j = 0; j < connections.length; j++) {
          income[connections[j]].add(j + 1);
        }
        int[] dfsRes = new int[n + 1];
        dfs(income, funFactors, 0, dfsRes);
        dfsRes[0] = 0;
        dfs2(income, 0, dfsRes, new HashSet<>());
        Set<Integer> leaves = new HashSet<>();
        for (int j = 0; j < income.length; j++) {
          if (income[j].isEmpty()) leaves.add(j);
        }
        int total = 0;
        for (int leave : leaves) {
          total += dfsRes[leave];
        }
        System.out.println("Case #" + (i + 1) + ": " + total);
      }
    }
  }
}
