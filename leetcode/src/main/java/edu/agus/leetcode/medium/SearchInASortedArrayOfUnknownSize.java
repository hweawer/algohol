package edu.agus.leetcode.medium;

public class SearchInASortedArrayOfUnknownSize {
  interface ArrayReader {
    int get(int index);
  }

  int binarySearch(int l, int r, ArrayReader reader, int target) {
    while (l <= r) {
      int mid = l + (r - l) / 2;
      int midE = reader.get(mid);
      if (midE == target) return mid;
      else if (midE == Integer.MAX_VALUE || midE > target) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return -1;
  }

  public int search(ArrayReader reader, int target) {
    int firstElement = reader.get(0);
    if (firstElement == target) return 0;
    int rightBorder = target - firstElement;
    int res = binarySearch(0, rightBorder, reader, target);
    return res;
  }
}
