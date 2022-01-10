package edu.agus.leetcode.easy;

public class FloodFill {
  public void dfs(int[][] image, int sr, int sc, int newColor) {
    if (image[sr][sc] == newColor) return;
    int oldColor = image[sr][sc];
    image[sr][sc] = newColor;
    if (sr - 1 >= 0 && image[sr - 1][sc] == oldColor) {
      dfs(image, sr - 1, sc, newColor);
    }
    if (sr + 1 < image.length && image[sr + 1][sc] == oldColor) {
      dfs(image, sr + 1, sc, newColor);
    }
    if (sc - 1 >= 0 && image[sr][sc - 1] == oldColor) {
      dfs(image, sr, sc - 1, newColor);
    }
    if (sc + 1 < image[0].length && image[sr][sc + 1] == oldColor) {
      dfs(image, sr, sc + 1, newColor);
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    dfs(image, sr, sc, newColor);
    return image;
  }
}
