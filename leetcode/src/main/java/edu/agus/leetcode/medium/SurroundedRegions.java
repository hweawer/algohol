package edu.agus.leetcode.medium;

public class SurroundedRegions {
  public void dfs(char[][] board, int i, int j) {
    int m = board.length;
    int n = board[0].length;
    if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
    board[i][j] = '*';
    dfs(board, i - 1, j);
    dfs(board, i, j + 1);
    dfs(board, i + 1, j);
    dfs(board, i, j - 1);
  }

  public void solve(char[][] board) {
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') dfs(board, i, j);
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O') board[i][j] = 'X';
        if (board[i][j] == '*') board[i][j] = 'O';
      }
    }
  }
}
