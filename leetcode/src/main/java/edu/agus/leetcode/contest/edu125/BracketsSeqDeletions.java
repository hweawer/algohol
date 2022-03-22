package edu.agus.leetcode.contest.edu125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BracketsSeqDeletions {

  static boolean isPalindrome(String word, int l, int r) {
    while (l < r) {
      if (word.charAt(l) != word.charAt(r)) return false;
      l++;
      r--;
    }
    return true;
  }

  static boolean isValid(String word, int l, int r) {
    Deque<Character> deq = new ArrayDeque<>();
    while (l <= r) {
      if (word.charAt(l) == ')' && deq.isEmpty()) return false;
      else if (word.charAt(l) == ')') deq.pop();
      else deq.push('(');
      l++;
    }
    return deq.isEmpty();
  }

  static int[] operations(String s) {
    int ops = 0;
    int l = 0;
    int r = l + 1;
    int last = 0;
    while (r < s.length()) {
      if (isPalindrome(s, l, r) || isValid(s, l, r)) {
        ops++;
        last = r;
        l = r + 1;
        r = l + 1;
      } else r++;
    }
    if (last == 0) return new int[]{ops, s.length()};
    return new int[]{ops, s.length() - 1 == last ? 0 : s.length() - 1 - last};
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(reader.readLine());
    for (int i = 0; i < t; i++) {
      String x = reader.readLine();
      String s = reader.readLine();
      int[] ans = operations(s);
      System.out.println(ans[0] + " " + ans[1]);
    }
  }
}
