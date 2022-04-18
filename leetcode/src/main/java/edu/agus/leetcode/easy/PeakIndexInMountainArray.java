package edu.agus.leetcode.easy;

public class PeakIndexInMountainArray {
  public int peakIndexInMountainArray(int[] arr) {
    int res = 0;

    int left = 0;
    int mid = 1;
    int right = 2;
    while(right < arr.length) {
      if (arr[mid] > arr[left] && arr[mid] > arr[right]) {
        if (arr[mid] > arr[res]) res = mid;
      }
      left++;
      mid++;
      right++;
    }
    return res;
  }
}
