package edu.agus.leetcode.medium;

public class LongestRepeatingCharacterReplacement {
  public static int characterReplacement(String s, int k) {
    int[] mem = new int[26];
    int res = 0;
    int maxf = 0;
    for (int left = 0, right = 0; right < s.length(); right++) {
      char cur = s.charAt(right);
      mem[cur - 'A']++;
      maxf = Math.max(maxf, mem[cur - 'A']);
      int length = right - left + 1;
      if (length - maxf <= k) {
        res = Math.max(res, length);
      } else {
        char l = s.charAt(left);
        mem[l - 'A']--;
        left++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    characterReplacement("ABAB", 2);
  }
}
