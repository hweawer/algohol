package edu.agus.leetcode.easy;

public class VersionControl {
  boolean isBadVersion(int version) {
    return false;
  }

  public class FirstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
      int l = 1;
      int r = n;
      int m;
      while (l < r) {
        m = l + (r - l) / 2;
        boolean x = isBadVersion(m);
        if (x) {
          r = m;
        } else {
          l = m + 1;
        }
      }
      return l;
    }
  }
}

