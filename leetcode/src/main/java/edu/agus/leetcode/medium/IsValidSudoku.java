package edu.agus.leetcode.medium;

import java.util.HashMap;

public class IsValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    HashMap<Integer, Integer>[] rows = new HashMap[9];
    HashMap<Integer, Integer>[] cols = new HashMap[9];
    HashMap<Integer, Integer>[] boxs = new HashMap[9];

    for (int i = 0; i < 9; ++i) {
      rows[i] = new HashMap<>();
      cols[i] = new HashMap<>();
      boxs[i] = new HashMap<>();
    }

    for (int i = 0; i < 9; ++i) {
      for (int j = 0; j < 9; ++j) {
        char val = board[i][j];

        if (val != '.') {
          int num = (int) val;
          int box_idx = (i / 3) * 3 + j / 3;
          rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
          cols[j].put(num, cols[j].getOrDefault(num, 0) + 1);
          boxs[box_idx].put(num, boxs[box_idx].getOrDefault(num, 0) + 1);
          if (rows[i].get(num) > 1 || cols[j].get(num) > 1 || boxs[box_idx].get(num) > 1) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
