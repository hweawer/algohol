package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AddBoldTagInString {
  void intervals(String s, String word, List<int[]> intervals) {
    int start = 0;
    while (start < s.length()) {
      int i = s.indexOf(word, start);
      if (i != -1) {
        int end = i + word.length();
        intervals.add(new int[]{i, end});
      }
      start++;
    }
  }

  private List<int[]> collapse(List<int[]> location) {
    Collections.sort(location, Comparator.comparingInt(a -> a[0]));
    List<int[]> newLocation = new ArrayList<>();

    for (int i = 0; i < location.size(); i++) {
      int size = newLocation.size();
      if (size == 0 || newLocation.get(size - 1)[1] < location.get(i)[0])
        newLocation.add(location.get(i));
      else
        newLocation.get(size - 1)[1] = Math.max(location.get(i)[1], newLocation.get(size - 1)[1]);
    }

    return newLocation;
  }

  public String addBoldTag(String s, String[] words) {
    List<int[]> intervals = new ArrayList<>();
    for (String word : words) intervals(s, word, intervals);
    List<int[]> merged = collapse(intervals);
    if (merged.size() == 0) return s;
    StringBuilder res = new StringBuilder();
    int pointer = 0;
    for (int i = 0; i < s.length(); i++) {
      if (i == merged.get(pointer)[0]) res.append("<b>");
      else if (i == merged.get(pointer)[1]) {
        res.append("</b>");
        if (pointer < merged.size() - 1) pointer++;
      }
      res.append(s.charAt(i));
    }
    if (merged.get(pointer)[1] == s.length()) res.append("</b>");
    return res.toString();
  }
}
