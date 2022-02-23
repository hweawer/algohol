package edu.agus.leetcode.medium;

public class PermutationInString {
  public static boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) return false;
    int[] map1 = new int[26];
    int n = s1.length();
    for (int i = 0; i < n; i++) {
      int ind = s1.charAt(i) - 'a';
      map1[ind]++;
    }
    int[] map2 = new int[26];
    for (int i = 0; i < n; i++) {
      int ind = s2.charAt(i) - 'a';
      map2[ind]++;
    }
    if (cmpmaps(map1, map2)) return true;
    for (int l = 1, r = n; r < s2.length(); r++, l++) {
      map2[s2.charAt(l - 1) - 'a']--;
      map2[s2.charAt(r) - 'a']++;
      if (cmpmaps(map1, map2)) return true;
    }
    return false;
  }

  static boolean cmpmaps(int[] m1, int[] m2) {
    for (int i = 0; i < 26; i++)
      if (m1[i] != m2[i]) return false;
    return true;
  }

  public static void main(String[] args) {
    checkInclusion("ab", "eidbaooo");
  }
}
