package edu.agus.leetcode.contest.n782;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
  static String solve(int r, int b) {
    int ret = (int) Math.round((double) r / b);
    StringBuilder sb = new StringBuilder();
    while (b > 0) {
      for (int i = 0; i < ret; i++) {
        sb.append('R');
      }
      sb.append('B');
      r -= ret;
      b--;
    }
    for (int i = 0; i < r; i++) {
      sb.append('R');
    }
    return sb.toString();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());
    for (int i = 0; i < t; i++) {
      String[] arrStr = reader.readLine().split(" ");
      int n = Integer.parseInt(arrStr[0]);
      int r = Integer.parseInt(arrStr[1]);
      int b = Integer.parseInt(arrStr[2]);
      System.out.println(solve(r, b));
    }
  }
}
