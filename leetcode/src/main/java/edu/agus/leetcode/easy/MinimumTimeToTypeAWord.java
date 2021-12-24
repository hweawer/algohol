package edu.agus.leetcode.easy;

public class MinimumTimeToTypeAWord {

  public static int minTimeToType(String word) {
    int current = 0;
    int result = 0;
    for (int i = 0; i < word.length(); i++) {
      int character = word.charAt(i) - 'a';
      int iter = Math.min(Math.abs(character - current), 26 - Math.abs(character - current));
      result += iter;
      result++;
      current = character;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(minTimeToType("bza"));
  }
}
