package edu.agus.leetcode.easy;

public class MergeSortedArray {
  public static void shift(int[] nums, int start, int m) {
    for (int i = start + m; i > start; i--) {
      nums[i] = nums[i - 1];
    }
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i1 = 0;
    int i2 = 0;
    while (i2 < n) {
      if (nums1[i1] < nums2[i2] && m > 0) {
        i1++;
        m--;
      } else if (nums1[i1] == nums2[i2]) {
        shift(nums1, i1 + 1, m - 1);
        i1++;
        nums1[i1] = nums2[i2];
        i2++;
      } else {
        if (m == 0) {
          while (i2 < n) {
            nums1[i1] = nums2[i2];
            i1++;
            i2++;
          }
        } else {
          shift(nums1, i1, m - 1);
          nums1[i1] = nums2[i2];
          i1++;
          i2++;
        }
      }
    }
  }

  public static void main(String[] args) {
    merge(new int[]{2, 0}, 3, new int[]{2, 5, 6}, 3);
  }
}
