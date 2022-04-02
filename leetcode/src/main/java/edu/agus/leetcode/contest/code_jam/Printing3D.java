package edu.agus.leetcode.contest.code_jam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Printing3D {
  public static class Solution {

    public static String solve(int c, int m, int y, int b) {
      int sum = c + m + y + b;
      if (sum < 1_000_000) return "IMPOSSIBLE";
      else if (sum == 1_000_000) return c + " " + m + " " + y + " " + b;
      else {
        int diff = sum - 1_000_000;
        while (diff != 0) {
          if (diff <= c) {
            c -= diff;
            diff = 0;
          } else if (diff <= m) {
            m -= diff;
            diff = 0;
          } else if (diff <= y) {
            y -= diff;
            diff = 0;
          } else if (diff <= b) {
            b -= diff;
            diff = 0;
          } else if (diff > c && c > 0) {
            diff -= c;
            c = 0;
          } else if (diff > m && m > 0) {
            diff -= m;
            m = 0;
          } else if (diff > y && y > 0) {
            diff -= y;
            y = 0;
          } else if (diff > b && b > 0) {
            diff -= b;
            b = 0;
          }
        }
        return c + " " + m + " " + y + " " + b;
      }
    }

    public static void main(String[] args) throws IOException {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt();
      for (int i = 0; i < t; i++) {
        int c = Integer.MAX_VALUE;
        int m = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
          c = Math.min(c, in.nextInt());
          m = Math.min(m, in.nextInt());
          y = Math.min(y, in.nextInt());
          b = Math.min(b, in.nextInt());
        }
        String solution = solve(c, m, y, b);
        System.out.println("Case #" + (i + 1) + ": " + solution);
      }
    }
  }
}
