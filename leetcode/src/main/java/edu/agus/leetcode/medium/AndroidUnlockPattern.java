package edu.agus.leetcode.medium;

public class AndroidUnlockPattern {
  public int numberOfPatterns(int m, int n) {
    // int[i][j] means the num in the 3*3 grid that lies between i & j (horizontally or vertically)
    // for ex : in 3*3 grid with num between [1,9], the middleNum between 1 & 3 (and similarly between 3 & 1) (horizontally) is 2
    // there is no number between 2 & 9 in the grid so it will be 0
    int[][] middleNum = new int[10][10];
    middleNum[1][3] = middleNum[3][1] = 2;
    middleNum[4][6] = middleNum[6][4] = 5;
    middleNum[7][9] = middleNum[9][7] = 8;
    middleNum[1][7] = middleNum[7][1] = 4;
    middleNum[2][8] = middleNum[8][2] = 5;
    middleNum[3][9] = middleNum[9][3] = 6;
    middleNum[1][9] = middleNum[9][1] = middleNum[3][7] = middleNum[7][3] = 5;

    boolean[] visited = new boolean[10];

    int res = 0;

    res += helperDFS(middleNum, visited, 1, 1, 0, m, n) * 4; // since num pattern formed starting 1, 3, 7 & 9 will be similar so we * 4
    res += helperDFS(middleNum, visited, 2, 1, 0, m, n) * 4; // since num pattern formed starting 2, 4, 6 & 8 will be similar so we * 4
    res += helperDFS(middleNum, visited, 5, 1, 0, m, n);

    return res;
  }

  private int helperDFS(int[][] middleNum, boolean[] visited, int num, int patternCurrLen, int acceptedPattern, int m, int n) {
    if (patternCurrLen >= m) { // since we need to find all the patterns whose length is BETWEEN [m, n] so if a pttern len becomes m or more then increase the accepted count
      acceptedPattern++;
    }

    patternCurrLen++; // we have a new number 'num' in pattern so increase the length (0 to start with)

    if (patternCurrLen > n)
      return acceptedPattern; // if length of current patter becomes GREATER THAN 'n' then we return (because len == 'n' we accept)

    // Recurse and backtrack
    visited[num] = true;
    for (int i = 1; i <= 9; i++) {
      int middleNumBetweenNumAndI = middleNum[num][i];
      // if the new num 'i' is not visited yet, AND
      // if the middle num between I and num is ) (meaning there is no num between them), OR
      // the middleNum bewteen them is already visted (so we can safely cross it)
      if (!visited[i] && (middleNumBetweenNumAndI == 0 || visited[middleNumBetweenNumAndI])) {
        acceptedPattern = helperDFS(middleNum, visited, i, patternCurrLen, acceptedPattern, m, n);
      }
    }
    visited[num] = false; // backtrack

    return acceptedPattern;
  }
}
