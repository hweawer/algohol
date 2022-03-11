package edu.agus.leetcode.easy;

public class SubstringsOfSize3WithDistinctCharacters {
  public int countGoodSubstrings(String s) {
    if (s.length() < 3) return 0;
    int k = 3;
    int res = 0;

    int[] dict = new int[26];
    for (int i = 0; i < k; i++) {
      dict[s.charAt(i) - 'a']++;
    }
    if (dict[s.charAt(0) - 'a'] == 1 && dict[s.charAt(1) - 'a'] == 1 && dict[s.charAt(2) - 'a'] == 1) res++;
    for (int left = 1, right = k; right < s.length(); left++, right++) {
      dict[s.charAt(left - 1) - 'a']--;
      dict[s.charAt(right) - 'a']++;
      if (dict[s.charAt(left) - 'a'] == 1 && dict[s.charAt(left + 1) - 'a'] == 1 && dict[s.charAt(right) - 'a'] == 1)
        res++;
    }
    return res;
  }
}
