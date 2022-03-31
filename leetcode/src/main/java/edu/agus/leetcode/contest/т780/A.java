package edu.agus.leetcode.contest.т780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
  static long max(long a, long b) {
    if (a == 0) return 1;
    return b * 2 + a + 1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());
    for (int i = 0; i < t; i++) {
      String[] arrStr = reader.readLine().split(" ");
      long a = Long.parseLong(arrStr[0]);
      long b = Long.parseLong(arrStr[1]);
      System.out.println(max(a, b));
    }
  }
}
