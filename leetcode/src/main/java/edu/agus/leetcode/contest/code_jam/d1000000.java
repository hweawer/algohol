package edu.agus.leetcode.contest.code_jam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class d1000000 {
  public static class Solution {
    public static int calc(int[] arr) {
      Arrays.sort(arr);
      int res = 0;
      int r = 0;
      int l = 0;
      int idx = 0;
      while (r < arr.length) {
        if (arr[r] > idx) {
          idx++;
          res = Math.max(res, r - l + 1);
          r++;
        } else {
          l++;
          idx--;
        }
      }
      return res;
    }

    public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(in.readLine());
      for (int i = 0; i < t; i++) {
        int n = Integer.parseInt(in.readLine());
        String[] line = in.readLine().split(" ");
        int[] arr = new int[n];
        for (int j = 0; j < n; j++) arr[j] = Integer.parseInt(line[j]);
        int c = calc(arr);
        System.out.println("Case #" + (i + 1) + ": " + c);
      }
    }
  }
}
