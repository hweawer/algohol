package edu.agus.leetcode.contest.edu125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XYSeq {
  public static long count(int n, int B, int x, int y) {
    int it = 0;
    long total = 0;
    for (int i = 0; i < n; i++) {
      if (it + x > B) it -= y;
      else it += x;
      total += it;
    }
    return total;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());
    int x;
    int y;
    int B;
    int n;
    for (int i = 0; i < t; i++) {
      String[] input = reader.readLine().split(" ");
      n = Integer.parseInt(input[0]);
      B = Integer.parseInt(input[1]);
      x = Integer.parseInt(input[2]);
      y = Integer.parseInt(input[3]);
      System.out.println(count(n, B, x, y));
    }
  }
}
