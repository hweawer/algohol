package edu.agus.leetcode.contest;

import java.io.*;

public class Robot {

  public static void main(String[] args) throws Exception {
    int leftStep = -1, botStep = -1, rightStep = 1, topStep = 1;
    boolean left = true, bot = false, right = false, top = false;
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintStream out = new PrintStream("output.txt");
    int n = Integer.parseInt(br.readLine());
    int x = 0;
    int y = 0;
    for (int i = 0; i < n; i++) {
      if (left) {
        x--;
        if (x == leftStep) {
          left = false;
          bot = true;
          leftStep--;
        }
      } else if (bot) {
        y--;
        if (y == botStep) {
          bot = false;
          right = true;
          botStep--;
        }
      } else if (right) {
        x++;
        if (x == rightStep) {
          right = false;
          top = true;
          rightStep++;
        }
      } else if (top) {
        y++;
        if (y == topStep) {
          top = false;
          left = true;
          topStep++;
        }
      }
    }
    out.println(x + " " + y);
  }
}
