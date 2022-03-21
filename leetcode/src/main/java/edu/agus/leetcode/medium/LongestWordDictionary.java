package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestWordDictionary {
  static class TrieNode {
    Map<Character, TrieNode> edges = new HashMap<>();
    boolean isWorldEnd = false;
  }

  public void insert(TrieNode node, String word) {
    TrieNode current = node;
    for (char c : word.toCharArray()) {
      if (!current.edges.containsKey(c)) {
        current.edges.put(c, new TrieNode());
      }
      current = current.edges.get(c);
    }
    current.isWorldEnd = true;
  }

  String res = "";

  public void longest(StringBuilder acc) {
    String s = acc.toString();
    if (s.length() > res.length()) res = s;
    else if (s.length() == res.length()) {
      if (s.compareTo(res) > 0) res = s;
    }
  }

  public void traverse(TrieNode node, StringBuilder acc) {
    if (node.edges.isEmpty()) longest(acc);
    else {
      for (Map.Entry<Character, TrieNode> en : node.edges.entrySet()) {
        TrieNode child = en.getValue();
        if (child.isWorldEnd) {
          traverse(child, acc.append(en.getKey()));
          acc.deleteCharAt(acc.length() - 1);
        } else longest(acc);
      }
    }
  }

  public String longestWord(String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      insert(root, word);
    }
    traverse(root, new StringBuilder());
    return res;
  }
}
