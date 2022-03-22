package edu.agus.leetcode.contest.edu125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CActions {

  static int count(long n) {
    int c = 0;
    long e = n;
    while (n > 0) {
      double sqrt = Math.sqrt(e);
      if (sqrt % 1 == 0) {
        c++;
        n -= e;
      } else e--;
    }
    return c;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());
    for (int i = 0; i < t; i++) {
      String[] input = reader.readLine().split(" ");
      long[] point = new long[]{Long.parseLong(input[0]), Long.parseLong(input[1])};
      long n = point[0] * point[0] + point[1] * point[1];
      System.out.println(count(n));
    }
  }
}
