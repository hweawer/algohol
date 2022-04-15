package edu.agus.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringTransformsIntoAnotherString {
  public boolean canConvert(String str1, String str2) {
    if (str1.equals(str2)) return true;
    Map<Character, Character> dict = new HashMap();
    Set<Character> uniqueCharactersInStr2 = new HashSet<>();
    for (int i = 0; i < str1.length(); i++) {
      if (dict.containsKey(str1.charAt(i)) && dict.get(str1.charAt(i)) != str2.charAt(i)) {
        return false;
      }
      dict.put(str1.charAt(i), str2.charAt(i));
      uniqueCharactersInStr2.add(str2.charAt(i));
    }

    if (uniqueCharactersInStr2.size() < 26) {
      return true;
    }
    return false;
  }
}
