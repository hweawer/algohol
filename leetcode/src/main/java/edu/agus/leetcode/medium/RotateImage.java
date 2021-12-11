package edu.agus.leetcode.medium;

public class RotateImage {
  public void rotate(int[][] matrix) {
    int temp;
    int[] temparray;
    int size = matrix.length;
    int last = size - 1;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size - i; j++) {
        temp = matrix[i][j];
        matrix[i][j] = matrix[last - j][last - i];
        matrix[last - j][last - i] = temp;
      }
    }
    int mid = size / 2;
    for (int i = 0; i < mid; i++) {
      temparray = matrix[i];
      matrix[i] = matrix[size - 1 - i];
      matrix[size - 1 - i] = temparray;
    }
  }
}
