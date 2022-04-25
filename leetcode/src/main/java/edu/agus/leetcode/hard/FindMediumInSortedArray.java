package edu.agus.leetcode.hard;

public class FindMediumInSortedArray {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    if (len1 > len2) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int total = len1 + len2;
    int half = total / 2;
    int l = 0;
    int r = len1 - 1;
    while (true) {
      int mid = l + (r - l) / 2;
      if (r < l) {
        mid = -1;
      }
      int j = half - 2 - mid;

      int first = mid >= 0 ? nums1[mid] : Integer.MIN_VALUE;
      int firstRight = mid < len1 - 1 ? nums1[mid + 1] : Integer.MAX_VALUE;

      int second = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
      int secondRight = j < len2 - 1 ? nums2[j + 1] : Integer.MAX_VALUE;

      if (first <= secondRight && second <= firstRight) {
        if (total % 2 == 1) {
          return Math.min(firstRight, secondRight);
        } else {
          return ((double) Math.max(first, second) + (double) Math.min(firstRight, secondRight)) / 2;
        }
      }

      if (first > secondRight) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
  }
}
