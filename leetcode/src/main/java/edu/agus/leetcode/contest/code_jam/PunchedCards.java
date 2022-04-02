package edu.agus.leetcode.contest.code_jam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PunchedCards {
  public static class Solution {

    public static void print(int r, int c) {
      int res_r = r * 2 + 1;
      int res_c = c * 2 + 1;
      for(int i = 0; i < res_r; i++) {
        for(int j = 0; j < res_c; j++) {
          if (i <= 1 && j <= 1) System.out.print('.');
          else {
            if ((i % 2) == 0) {
              if (j % 2 == 0) System.out.print('+');
              else System.out.print('-');
            } else {
              if (j % 2 == 0) System.out.print('|');
              else System.out.print('.');
            }
          }
        }
        System.out.println();
      }
    }

    public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(in.readLine());
      int r;
      int c;
      for (int i = 0; i <= t; i++) {
        String[] line = in.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);
        System.out.println("Case #" + (i + 1) + ":");
        print(r, c);
      }
    }
  }
}
