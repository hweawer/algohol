package edu.agus.leetcode.medium;

public class MaximumNumberOfVowelsInSubstringOfGivenLength {
  public static boolean isVowel(Character c) {
    return c == 'a' || c == 'e' || c == 'u' || c == 'i' || c == 'o' || c == 'y';
  }

  public static int maxVowels(String s, int k) {
    int max = 0;
    for (int i = 0; i < k; i++) {
      if (isVowel(s.charAt(i))) max++;
    }
    int prev = max;

    for (int left = 1, right = k; right < s.length(); left++, right++) {
      int c = prev;
      if (isVowel(s.charAt(left - 1))) c--;
      if (isVowel(s.charAt(right))) c++;
      max = Math.max(max, c);
      prev = c;
    }
    return max;
  }

  public static void main(String[] args) {
    maxVowels("abciiidef",
        3
    );
  }
}
