package edu.agus.codeforces.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchWithJokers {
  static List<Integer> solve(String word, String pattern) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < word.length(); i++) {
      int pi = i;
      int it = 0;
      while (pi < word.length() && it < pattern.length() && (pattern.charAt(it) == word.charAt(pi) || pattern.charAt(it) == '?')) {
        pi++;
        it++;
      }
      if (it == pattern.length()) result.add(i);
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      String word = scanner.next();
      String pattern = scanner.next();
      List<Integer> res = solve(word, pattern);
      System.out.println(res.size());
      System.out.println(res.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
  }
}
