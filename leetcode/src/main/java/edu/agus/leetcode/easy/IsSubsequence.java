package edu.agus.leetcode.easy;

public class IsSubsequence {
  public boolean isSubsequence(String s, String t) {
    if (s.isEmpty() && t.isEmpty()) return true;
    if (s.length() > t.length()) return true;

    int fast = 0;
    int slow = 0;
    while (fast < t.length() && slow < s.length()) {
      if (s.charAt(slow) == t.charAt(fast)) {
        slow++;
      }
      fast++;
    }
    return slow == s.length();
  }
}
