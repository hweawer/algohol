package edu.agus.leetcode.contest.т780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
  static boolean eval(long[] arr) {
    if (arr.length == 1) return arr[0] == 1;
    long max = 0;
    long prev = 0;
    for (long l : arr) {
      if (l > max) {
        prev = max;
        max = l;
      } else if (l > prev) {
        prev = l;
      }
    }
    return max - prev <= 1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());
    for (int i = 0; i < t; i++) {
      String n = reader.readLine();
      String[] arrStr = reader.readLine().split(" ");
      long[] in = new long[arrStr.length];
      for (int j = 0; j < arrStr.length; j++) {
        in[j] = Long.parseLong(arrStr[j]);
      }
      if (eval(in)) System.out.println("YES");
      else System.out.println("NO");
    }
  }
}
