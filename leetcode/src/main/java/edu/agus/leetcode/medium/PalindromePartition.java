package edu.agus.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
  List<List<String>> res = new ArrayList<>();
  List<String> partition = new ArrayList<>();

  public boolean isPalindrome(String s, int l, int r) {
    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) return false;
      l++;
      r--;
    }
    return true;
  }

  public void dfs(String s, int i, int last) {
    if (i >= last) res.add(new ArrayList<>(partition));
    else {
      for (int j = i; j < s.length(); j++) {
        if (isPalindrome(s, i, j)) {
          String sub = s.substring(i, j + 1);
          partition.add(sub);
          dfs(s, j + 1, last);
          partition.remove(partition.size() - 1);
        }
      }
    }
  }

  public List<List<String>> partition(String s) {
    dfs(s, 0, s.length());
    return res;
  }
}
