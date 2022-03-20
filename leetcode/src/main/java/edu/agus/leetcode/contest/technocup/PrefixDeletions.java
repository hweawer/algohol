package edu.agus.leetcode.contest.technocup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrefixDeletions {

  public static String alg(String s, int[] lastIndexOf) {
    if (s.isEmpty()) return s;
    int pos = 0;
    while (pos < s.length() && pos < lastIndexOf[s.charAt(pos) - 'a']) {
      pos++;
    }
    return s.substring(pos);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      String s = br.readLine();
      int[] lastIndexOf = new int[26];
      for (int j = 0; j < s.length(); j++) {
        lastIndexOf[s.charAt(j) - 'a'] = j;
      }
      System.out.println(alg(s, lastIndexOf));
    }
  }
}
