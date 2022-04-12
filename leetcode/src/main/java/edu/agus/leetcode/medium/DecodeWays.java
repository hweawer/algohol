package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
  Map<Integer, Integer> cache = new HashMap();

  int dfs(int index, String word) {
    if (index >= word.length()) return 1;
    if (cache.containsKey(index)) return cache.get(index);

    int res = 0;
    String single = String.valueOf(word.charAt(index));
    if (!single.equals("0")) {
      res += dfs(index + 1, word);
    }

    if (index < word.length() - 1) {
      String pair = word.substring(index, index + 2);
      if (pair.charAt(0) == '1' || pair.charAt(0) == '2' && Integer.parseInt(pair) <= 26) {
        res += dfs(index + 2, word);
      }
    }
    cache.put(index, res);
    return res;
  }

  public int numDecodings(String s) {
    return dfs(0, s);
  }
}
