package edu.agus.leetcode.hard;

import java.util.*;

public class MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix {
  int[][] dirs = new int[][]{{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  Set<Integer> visited = new HashSet();

  public List<Integer> next(int n, int r, int c) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < r; i++)
      for (int j = 0; j < c; j++) {
        int newMask = n;
        for (int[] dir : dirs) {
          int nx = i + dir[0];
          int ny = j + dir[1];

          if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
          newMask = newMask ^ (1 << (nx * 3 + ny));
        }
        if (visited.add(newMask)) ans.add(newMask);
      }
    return ans;
  }

  public int minFlips(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;

    int mask = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        mask |= mat[i][j] << i * 3 + j;
      }
    }

    if (mask == 0) return 0;

    Queue<Integer> q = new LinkedList();
    q.add(mask);
    int level = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int top = q.poll();
        if (top == 0) return level;
        List<Integer> states = next(top, m, n);
        for (int s : states) q.add(s);
      }
      level++;
    }
    return -1;
  }
}
