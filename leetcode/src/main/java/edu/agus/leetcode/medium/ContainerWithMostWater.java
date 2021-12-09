package edu.agus.leetcode.medium;

public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int area = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      area = Math.max(area, (right - left) * Math.min(height[left], height[right]));
      if (height[left] <= height[right]) left++;
      else right--;
    }
    return area;
  }
}
