package edu.agus.leetcode.contest.edu126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
  static int CACHE_SIZE = 32_768;
  static int[] cache = new int[CACHE_SIZE + 1];

  static void buildCache() {
    for (int i = CACHE_SIZE - 1; i >= 1; i--) {
      if (cache[(i + 1) % 32768] != Integer.MAX_VALUE) {
        cache[i] = Math.min(cache[(i + 1) % 32768] + 1, cache[i]);
        if (i % 2 == 0) {
          cache[(i / 2)] = Math.min(cache[i / 2], cache[i] - 1);
        }
      }
      if (cache[(2 * i) % 32768] != Integer.MAX_VALUE) {
        cache[i] = Math.min(cache[(2 * i) % 32768] + 1, cache[i]);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Arrays.fill(cache, Integer.MAX_VALUE);
    cache[0] = 0;
    cache[CACHE_SIZE] = 0;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    int[] first = new int[n];
    String[] firstStr = reader.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      first[i] = Integer.parseInt(firstStr[i]);
    }
    int[] result = new int[n];
    buildCache();
    for (int i = 0; i < n; i++) {
      result[i] = cache[first[i]];
    }
    StringBuilder sb = new StringBuilder();
    for (int x : result) {
      sb.append(x).append(" ");
    }
    System.out.println(sb.toString().trim());
  }
}
