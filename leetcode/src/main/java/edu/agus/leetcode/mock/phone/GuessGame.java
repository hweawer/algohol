package edu.agus.leetcode.mock.phone;

public class GuessGame {
  public int guess(int x) {
    return x;
  }

  public int innerGuess(int l, int r) {
    int m = l + (r - l) / 2;
    int g = guess(m);
    if (g == 0) return m;
    else if (g == 1) return innerGuess(m + 1, r);
    else return innerGuess(l, m - 1);
  }

  public int guessNumber(int n) {
    return innerGuess(1, n);
  }
}
