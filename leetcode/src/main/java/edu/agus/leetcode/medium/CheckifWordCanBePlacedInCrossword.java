package edu.agus.leetcode.medium;

public class CheckifWordCanBePlacedInCrossword {
  public boolean placeWordInCrossword(char[][] board, String word) {
    char[] chars = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == chars[0] || board[i][j] == ' ') {
          boolean res = false;
          if (i == 0 || board[i - 1][j] == '#') {
            res |= search(board, i, j, chars, 0, Direction.DOWN);
          }
          if (i == board.length - 1 || board[i + 1][j] == '#') {
            res |= search(board, i, j, chars, 0, Direction.UP);
          }
          if (j == 0 || board[i][j - 1] == '#') {
            res |= search(board, i, j, chars, 0, Direction.RIGHT);
          }
          if (j == board[0].length - 1 || board[i][j + 1] == '#') {
            res |= search(board, i, j, chars, 0, Direction.LEFT);
          }
          if (res) {
            return res;
          }
        }
      }
    }
    return false;
  }


  private boolean search(char[][] board, int i, int j, char[] word, int cur, Direction dir) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || cur == word.length || board[i][j] == '#') {
      return false;
    }
    if (Character.isLetter(board[i][j]) && board[i][j] != word[cur]) return false;
    if ((board[i][j] == word[cur] || board[i][j] == ' ') && cur == word.length - 1 && isOnEdge(board, i, j, dir)) {
      return true;
    }
    switch (dir) {
      case UP:
        return search(board, i - 1, j, word, cur + 1, dir);
      case DOWN:
        return search(board, i + 1, j, word, cur + 1, dir);
      case LEFT:
        return search(board, i, j - 1, word, cur + 1, dir);
      case RIGHT:
        return search(board, i, j + 1, word, cur + 1, dir);
      default:
        return false;
    }

  }

  private boolean isOnEdge(char[][] board, int i, int j, Direction dir) {
    switch (dir) {
      case UP:
        return i == 0 || board[i - 1][j] == '#';
      case DOWN:
        return i == board.length - 1 || board[i + 1][j] == '#';
      case LEFT:
        return j == 0 || board[i][j - 1] == '#';
      case RIGHT:
        return j == board[0].length - 1 || board[i][j + 1] == '#';
      default:
        return false;
    }
  }

  enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;
  }
}
