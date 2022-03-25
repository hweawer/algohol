package edu.agus.leetcode.contest.ton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodPairs {

  static long[] goodPair(long[] nums) {
    int min = 0;
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < nums[min]) min = i;
      if (nums[i] > nums[max]) max = i;
    }
    return new long[]{min + 1, max + 1};
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(reader.readLine());
      String[] arrStr = reader.readLine().split(" ");
      long[] arr = new long[arrStr.length];
      for (int j = 0; j < arrStr.length; j++) {
        arr[j] = Long.parseLong(arrStr[j]);
      }
      long[] res = goodPair(arr);
      System.out.println(res[0] + " " + res[1]);
    }
  }
}
