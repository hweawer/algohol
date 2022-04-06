package edu.agus.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class FindAndReplaceInString {
  static class Entry {
    int idx;
    String source;
    String target;

    Entry(int i, String source, String target) {
      this.idx = i;
      this.source = source;
      this.target = target;
    }
  }

  boolean cmp(String s, int start, String source) {
    if (s.length() - start < source.length()) return false;
    int l = 0;
    while (l < source.length() && s.charAt(start) == source.charAt(l)) {
      l++;
      start++;
    }
    return l == source.length();
  }

  public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
    int n = indices.length;
    Entry[] arr = new Entry[n];
    for (int i = 0; i < sources.length; i++) {
      arr[i] = new Entry(indices[i], sources[i], targets[i]);
    }
    Arrays.sort(arr, Comparator.comparingInt(x -> x.idx));
    int it = 0;
    int p = 0;
    StringBuilder sb = new StringBuilder();
    while (it < s.length()) {
      if (p >= arr.length) {
        sb.append(s.charAt(it++));
      } else if (it != arr[p].idx) {
        sb.append(s.charAt(it++));
      } else {
        if (cmp(s, it, arr[p].source)) {
          sb.append(arr[p].target);
          it += arr[p].source.length();
        } else sb.append(s.charAt(it++));
        p++;
      }
    }
    return sb.toString();
  }
}
