package edu.agus.leetcode.easy;

public class StrStr {
  public int strStr(String haystack, String needle) {
    if (needle.equals("")) return 0;
    boolean isEqual = true;
    for (int i = 0; i < haystack.length(); i++) {
      if (haystack.length() - i < needle.length()) return -1;

      if (haystack.charAt(i) == needle.charAt(0)) {
        if (needle.length() == 1) return i;
        else {
          for (int j = i + 1, k = 1; j < haystack.length() && k < needle.length() && isEqual; j++, k++) {
            if (haystack.charAt(j) != needle.charAt(k)) isEqual = false;
          }
          if (isEqual) return i;
          isEqual = true;
        }
      }
    }

    return -1;
  }
}
