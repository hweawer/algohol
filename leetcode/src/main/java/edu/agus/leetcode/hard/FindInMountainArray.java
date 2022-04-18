package edu.agus.leetcode.hard;

public class FindInMountainArray {
  interface MountainArray {
    int get(int index);

    int length();
  }

  public int findInMountainArray(int target, MountainArray mountainArr) {
    int len = mountainArr.length();
    int peekIndex = find(mountainArr, 0, len - 1);
    int leftSide = findLeft(mountainArr, 0, peekIndex, target);
    if (leftSide != -1) return leftSide;
    if (mountainArr.get(peekIndex) == target) return peekIndex;
    return findRight(mountainArr, peekIndex + 1, len - 1, target);
  }


  int find(MountainArray mountainArr, int left, int right) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int midElem = mountainArr.get(mid);
      if (mountainArr.get(mid - 1) < midElem && mountainArr.get(mid + 1) < midElem) return mid;

      if (mountainArr.get(mid + 1) >= midElem) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return -1;
  }

  int findLeft(MountainArray mountainArr, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int midElem = mountainArr.get(mid);
      if (midElem == target) return mid;

      if (target < midElem) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  int findRight(MountainArray mountainArr, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int midElem = mountainArr.get(mid);
      if (midElem == target) return mid;

      if (target < midElem) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
