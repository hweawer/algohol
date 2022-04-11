package edu.agus.leetcode.medium;

public class AlphabetBoardPath {
  public String alphabetBoardPath(String target) {
    int currentRow = 0;
    int currentCol = 0;
    int left = 0;
    StringBuilder sb = new StringBuilder();
    while (left < target.length()) {
      char letter = (char) ('a' + currentRow * 5 + currentCol);
      if (letter == target.charAt(left)) sb.append("!");
      else {
        int c = target.charAt(left) - 'a'; // 25
        int col = c % 5; // 0
        int row = (c / 5); // 5
        int diffVertical = row - currentRow; // 2
        int diffHorizontal = col - currentCol; // 1
        if (row == 5 && diffHorizontal != 0) {
          diffVertical--;
        }
        if (diffVertical < 0) for (int i = 0; i < Math.abs(diffVertical); i++) sb.append("U");
        else if (diffVertical > 0) for (int i = 0; i < Math.abs(diffVertical); i++) sb.append("D");
        if (diffHorizontal < 0) for (int i = 0; i < Math.abs(diffHorizontal); i++) sb.append("L");
        else if (diffHorizontal > 0) for (int i = 0; i < Math.abs(diffHorizontal); i++) sb.append("R");
        if (row == 5 && diffHorizontal != 0) {
          sb.append("D");
        }
        sb.append("!");
        currentRow = row;
        currentCol = col;
      }
      left++;
    }
    return sb.toString();
  }
}
