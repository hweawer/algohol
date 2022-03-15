package edu.agus.leetcode.medium;

public class WordSearch {
  boolean dfs(String word, int pos, char[][] board, boolean[][] visited, int i, int j, int m, int n) {
    char letter = word.charAt(pos);
    if (pos == word.length() - 1 && letter == board[i][j]) return true;
    if (letter != board[i][j]) return false;
    boolean left = false;
    boolean top = false;
    boolean bot = false;
    boolean right = false;
    visited[i][j] = true;
    if (i < m - 1 && !visited[i + 1][j]) bot = dfs(word, pos + 1, board, visited, i + 1, j, m, n);
    if (j < n - 1 && !visited[i][j + 1]) right = dfs(word, pos + 1, board, visited, i, j + 1, m, n);
    if (i > 0 && !visited[i - 1][j]) left = dfs(word, pos + 1, board, visited, i - 1, j, m, n);
    if (j > 0 && !visited[i][j - 1]) top = dfs(word, pos + 1, board, visited, i, j - 1, m, n);
    visited[i][j] = false;
    return left || top || bot || right;
  }

  public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    boolean[][] visited = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (dfs(word, 0, board, visited, i, j, m, n)) return true;
      }
    }
    return false;
  }
}
