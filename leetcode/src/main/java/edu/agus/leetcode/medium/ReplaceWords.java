package edu.agus.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {
  static class TrieNode {
    Map<Character, TrieNode> edges = new HashMap<>();
    boolean isWordEnd = false;
  }

  TrieNode root = new TrieNode();

  public void insert(String word) {
    TrieNode current = root;
    for (char c : word.toCharArray()) {
      if (!current.edges.containsKey(c)) {
        current.edges.put(c, new TrieNode());
      }
      current = current.edges.get(c);
    }
    current.isWordEnd = true;
  }

  public TrieNode find(String word, TrieNode node) {
    TrieNode current = node;
    for (char c : word.toCharArray()) {
      if (!current.edges.containsKey(c)) return null;
      current = current.edges.get(c);
    }
    return current;
  }

  public String replace(String word) {
    StringBuilder sb = new StringBuilder();
    TrieNode current = root;
    for (char c : word.toCharArray()) {
      current = find(String.valueOf(c), current);
      if (current == null) break;
      sb.append(c);
      if (current.isWordEnd) return sb.toString();
    }
    return word;
  }

  public String replaceWords(List<String> dictionary, String sentence) {
    for (String word : dictionary) insert(word);
    String[] words = sentence.split(" ");
    String[] res = new String[words.length];
    for (int i = 0; i < words.length; i++) {
      res[i] = replace(words[i]);
    }
    return String.join(" ", res);
  }
}
