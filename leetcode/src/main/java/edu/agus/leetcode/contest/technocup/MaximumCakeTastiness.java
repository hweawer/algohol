package edu.agus.leetcode.contest.technocup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumCakeTastiness {

  public static int alg(int[] ints) {
    if (ints.length == 2) return ints[0] + ints[1];
    int max = 0;
    int prevMax = 0;
    for (int i : ints) {
      int temp = max;
      max = Math.max(max, i);
      if (i == max && i == temp) {
        prevMax = i;
      } else if (i == max) {
        prevMax = temp;
      } else {
        prevMax = Math.max(prevMax, i);
      }
    }
    return max + prevMax;
  }


  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(reader.readLine());
      String[] strPices = reader.readLine().split(" ");
      int[] pices = new int[strPices.length];
      for (int j = 0; j < strPices.length; j++) {
        pices[j] = Integer.parseInt(strPices[j]);
      }
      System.out.println(alg(pices));
    }
  }
}
