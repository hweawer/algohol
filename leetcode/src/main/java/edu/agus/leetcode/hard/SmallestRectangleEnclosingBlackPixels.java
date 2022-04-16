package edu.agus.leetcode.hard;

public class SmallestRectangleEnclosingBlackPixels {
  int searchBorderY(char[][] image, int i, int j, int top, int bot, boolean whiteToBlack) {
    while (i != j) {
      int mid = i + (j - i) / 2;
      int k = top;
      while (k < bot && image[k][mid] == '0') k++;
      if (k < bot == whiteToBlack) {
        j = mid;
      } else {
        i = mid + 1;
      }
    }
    return i;
  }

  int searchBorderX(char[][] image, int i, int j, int left, int right, boolean whiteToBlack) {
    while (i != j) {
      int mid = i + (j - i) / 2;
      int k = left;
      while (k < right && image[mid][k] == '0') k++;
      if (k < right == whiteToBlack) {
        j = mid;
      } else {
        i = mid + 1;
      }
    }
    return i;
  }

  public int minArea(char[][] image, int x, int y) {
    int m = image.length;
    int n = image[0].length;
    int left = searchBorderY(image, 0, y, 0, m, true);
    int right = searchBorderY(image, y + 1, n, 0, m, false);
    int bot = searchBorderX(image, 0, x, 0, n, true);
    int top = searchBorderX(image, x + 1, m, 0, n, false);
    return (right - left) * (top - bot);
  }
}
