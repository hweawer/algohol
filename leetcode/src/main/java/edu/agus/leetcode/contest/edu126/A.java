package edu.agus.leetcode.contest.edu126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
  static long solve(long[] first, long[] second) {
    int n = first.length;
    for (int i = 1; i < n; i++) {
      long now = Math.abs(first[i] - first[i - 1]) + Math.abs(second[i] - second[i - 1]);
      long change = Math.abs(second[i] - first[i - 1]) + Math.abs(first[i] - second[i - 1]);
      if (change < now) {
        long temp = first[i];
        first[i] = second[i];
        second[i] = temp;
      }
    }
    long sum = 0;
    for (int i = 1; i < n; i++) {
      sum += Math.abs(first[i] - first[i - 1]) + Math.abs(second[i] - second[i - 1]);
    }
    return sum;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());
    for (int j = 0; j < t; j++) {
      int n = Integer.parseInt(reader.readLine());
      String[] firstStr = reader.readLine().split(" ");
      long[] first = new long[n];
      for (int i = 0; i < n; i++) {
        first[i] = Long.parseLong(firstStr[i]);
      }
      String[] secondStr = reader.readLine().split(" ");
      long[] second = new long[n];
      for (int i = 0; i < n; i++) {
        second[i] = Long.parseLong(secondStr[i]);
      }
      System.out.println(solve(first, second));
    }
  }
}
