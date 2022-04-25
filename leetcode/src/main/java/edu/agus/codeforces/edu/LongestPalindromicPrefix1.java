package edu.agus.codeforces.edu;

import java.util.Scanner;

public class LongestPalindromicPrefix1 {

  static boolean isPalindrome(String word, int right) {
    int left = 0;
    while (left < right) {
      if (word.charAt(left++) != word.charAt(right--)) return false;
    }
    return true;
  }

  static int prefix(String word) {
    int max = 1;
    for (int right = 1; right < word.length(); right++) {
      if (isPalindrome(word, right)) {
        max = Math.max(max, right + 1);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      String word = scanner.next();
      System.out.println(prefix(word));
    }
  }
}
